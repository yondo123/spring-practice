package kr.co.whatTodo.beans;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserInfoBean {
	private int userIndex;
	@Size(min = 2, max = 10) // length 2~10
	@Pattern(regexp = "[가-힣]*") // only korean
	private String userName;
	@Size(min = 5, max = 10)
	@Pattern(regexp = "^[0-9a-z]+$*") // only English
	private String userId;
	@Size(min = 5, max = 20)
	@Pattern(regexp = "^.*(?=^.{5,20}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$", message = "비밀번호는 5~20자의 특수문자, 숫자 영문을 포함한 문자만 허용됩니다.")
	private String userPw;
	private String confirmPw; // 비밀번호 확인
	private Boolean isUserCheck;
	private Boolean isLogin;

	public UserInfoBean() {
		this.isLogin = false;
		this.isUserCheck = false;
	}

	public int getUserIndex() {
		return userIndex;
	}

	public void setUserIndex(int userIndex) {
		this.userIndex = userIndex;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getConfirmPw() {
		return confirmPw;
	}

	public void setConfirmPw(String confirmPw) {
		this.confirmPw = confirmPw;
	}

	public Boolean getisUserCheck() {
		return isUserCheck;
	}

	public void setisUserCheck(Boolean isUserCheck) {
		this.isUserCheck = isUserCheck;
	}

	public Boolean getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(Boolean isLogin) {
		this.isLogin = isLogin;
	}

}
