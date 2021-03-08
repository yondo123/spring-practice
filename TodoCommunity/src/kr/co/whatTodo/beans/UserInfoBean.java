package kr.co.whatTodo.beans;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserInfoBean {
	private int USER_INDEX;
	@Size(min = 2, max = 10) // length 2~10
	@Pattern(regexp = "[가-힣]*") // only korean
	private String USER_NAME;
	@Size(min = 5, max = 10)
	@Pattern(regexp = "[a-zA-Z]*") // only English
	private String USER_ID;
	@Size(min = 5, max = 20)
	@Pattern(regexp = "[a-zA-Z]*") // only English
	private String USER_PW;
	public int getUSER_INDEX() {
		return USER_INDEX;
	}

	public void setUSER_INDEX(int uSER_INDEX) {
		USER_INDEX = uSER_INDEX;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_PW() {
		return USER_PW;
	}

	public void setUSER_PW(String uSER_PW) {
		USER_PW = uSER_PW;
	}

}
