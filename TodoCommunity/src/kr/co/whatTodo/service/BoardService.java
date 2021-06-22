package kr.co.whatTodo.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.whatTodo.beans.BoardListBean;
import kr.co.whatTodo.beans.CategoryBean;
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
	private String fileProcessing(MultipartFile uploadFile, Boolean temporary) {
		String fileName = System.currentTimeMillis() + "_" + userInfoBean.getUserIndex();
		String directory = temporary ? uploadFilePath + File.separator + "temporary" : uploadFilePath;
		File uploadDir = new File(directory);
		try {
			if (!uploadDir.exists()) {
				try {
					uploadDir.mkdir();
				} catch (Exception e) {
					e.getStackTrace();
				}
			}
			uploadFile.transferTo(new File(directory + File.separator + fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fileName;
	}
	
	// 임시파일 이동
	private void moveFile() {
		
	}

	// 이미지 파일 업로드
	public String addImageFile(MultipartFile imageFile) {
		String imageName = fileProcessing(imageFile, true);
		int userIndex = userInfoBean.getUserIndex();
		boardDao.insertDumpImage(userIndex, imageName);
		return imageName;
	}

	// 게시판 전체 갯수
	public int getContentTotalCount(int boardIndex) {
		return boardDao.selectContentTotalCount(boardIndex);
	}

	// 게시판 글 쓰기
	public void addPost(BoardListBean boardListBean) {
		boardListBean.setWriterIndex(userInfoBean.getUserIndex());
		boardDao.insertContentInfo(boardListBean);
	}

	// 게시글 목록 조회
	public List<BoardListBean> getContentList(int boardIndex, int reqPage) {
		int startRow = (reqPage - 1) * boardListCnt;
		RowBounds rowBounds = new RowBounds(startRow, boardListCnt);
		return boardDao.selectContentList(boardIndex, rowBounds);
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
