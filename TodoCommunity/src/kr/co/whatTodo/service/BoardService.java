package kr.co.whatTodo.service;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.whatTodo.beans.BoardListBean;
import kr.co.whatTodo.beans.UserInfoBean;
import kr.co.whatTodo.dao.BoardDao;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {
	@Autowired
	private BoardDao boardDao;

	@Value("${filePath}")
	private String uploadFilePath;

	@Resource(name = "loginUserInfoBean")
	private UserInfoBean userInfoBean;

	private String fileProcessing(MultipartFile uploadFile) {
		String fileName = System.currentTimeMillis() + "_" + uploadFile.getOriginalFilename();
		try {
			uploadFile.transferTo(new File(uploadFilePath + "/" + fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fileName;
	}

	// 게시판 글 쓰기
	public void addPost(BoardListBean boardListBean) {

		MultipartFile uploadFile = boardListBean.getUploadFile();
		if (uploadFile != null && uploadFile.getSize() > 0) {
			boardListBean.setFile(fileProcessing(uploadFile));
		}
		boardListBean.setWriterIndex(userInfoBean.getUserIndex());
		boardDao.insertContentInfo(boardListBean);
	}
}
