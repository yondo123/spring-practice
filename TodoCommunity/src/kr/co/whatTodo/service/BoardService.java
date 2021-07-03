package kr.co.whatTodo.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import kr.co.whatTodo.beans.BoardListBean;
import kr.co.whatTodo.beans.CategoryBean;
import kr.co.whatTodo.beans.PostBean;
import kr.co.whatTodo.beans.UserInfoBean;
import kr.co.whatTodo.dao.BoardDao;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {
	@Autowired
	private BoardDao boardDao;

	@Value("${boardListCount}")
	private int boardListCnt;

	@Value("${filePath}")
	private String uploadFilePath;

	@Resource(name = "loginUserInfoBean")
	private UserInfoBean userInfoBean;

	// 파일 처리
	private String saveTemporaryFile(MultipartFile tempFile) {
		String extension = "." + FilenameUtils.getExtension(tempFile.getOriginalFilename());
		String fileName = System.currentTimeMillis() + "_" + userInfoBean.getUserIndex() + extension;
		String directory = uploadFilePath + File.separator + "temporary";
		File uploadDir = new File(directory);
		try {
			if (!uploadDir.exists()) {
				try {
					uploadDir.mkdir();
				} catch (Exception e) {
					e.getStackTrace();
				}
			}
			tempFile.transferTo(new File(directory + File.separator + fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fileName;
	}
	
	// 임시파일 이동
	private void moveFile(String imagePath) {
		String tempPath = uploadFilePath + File.separator + "temporary" + File.separator + imagePath;
		String uploadPath = uploadFilePath + File.separator + imagePath;
		File targetFile = FileUtils.getFile(tempPath);
		File moveToFile = FileUtils.getFile(uploadPath);
		try {
			FileUtils.moveFile(targetFile, moveToFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 이미지 파일 업로드
	public String addImageFile(MultipartFile imageFile) {
		String imageName = saveTemporaryFile(imageFile);
		int userIndex = userInfoBean.getUserIndex();
		boardDao.insertDumpImage(userIndex, imageName);
		return imageName;
	}

	// 게시판 전체 갯수
	public int getContentTotalCount(int boardIndex) {
		return boardDao.selectContentTotalCount(boardIndex);
	}

	// 게시판 글 쓰기
	public void addPost(BoardListBean boardListBean, ArrayList<String> sessionTempImage) {
		for(String uploadImage : boardListBean.getUploadImageList()) {
			if(sessionTempImage.contains(uploadImage)) {
				String tempFilePath = boardDao.selectUploadFilePath(uploadImage);
				moveFile(tempFilePath);
			}
		}
		
		boardListBean.setWriterIndex(userInfoBean.getUserIndex());
		boardDao.insertContentInfo(boardListBean);
	}

	// 게시글 목록 조회
	public List<BoardListBean> getContentList(int boardIndex, int reqPage) {
		int startRow = (reqPage - 1) * boardListCnt;
		RowBounds rowBounds = new RowBounds(startRow, boardListCnt);
		return boardDao.selectContentList(boardIndex, rowBounds);
	}
	
	// 게시글 상세 조회
	public PostBean getPostInfo(int contentIndex) {
		return boardDao.selectPostInfo(contentIndex);
	}
	
	// 게시글 수정
	public void modifyPostInfo(BoardListBean boardListBean, ArrayList<String> sessionTempImage) {
		for(String uploadImage : boardListBean.getUploadImageList()) {
			if(sessionTempImage.contains(uploadImage)) {
				String tempFilePath = boardDao.selectUploadFilePath(uploadImage);
				moveFile(tempFilePath);
			}
		}
		
		boardDao.updateContentInfo(boardListBean);
	}

	// 카테고리 목록 조회
	public List<CategoryBean> getCategoryList(String cateType) {
		if (cateType.equals("study")) {
			return boardDao.selectCategoryList();
		} else {
			return boardDao.selectCategoryList();
		}
	}
}
