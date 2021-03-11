package kr.co.whatTodo.beans;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserInfoBean {
	private int userIndex;
	@Size(min = 2, max = 10, message ="성함이 올바르지 않습니다.") // length 2~10
	@Pattern(regexp = "[가-힣]*", message = "성함이 올바르지 않습니다.") // only korean
	private String userName;
	@Size(min = 5, max = 10, message = "아이디는 5~10자의 영문, 숫자만 허용됩니다.")
	@Pattern(regexp = "^[0-9a-z]+$*", message = "아이디는 5~10자의 영문, 숫자만 허용됩니다.") // only English
	private String userId;
	@Size(min = 5, max = 20)
	@Pattern(regexp = "(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[^\\w\\s]).*", message = "비밀번호는 5~20자의 특수문자를 포함한 문자만 허용됩니다.")
	private String userPw;

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

}
