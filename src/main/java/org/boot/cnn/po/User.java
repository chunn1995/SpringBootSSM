package org.boot.cnn.po;

import java.util.Date;

public class User {
	// 属性名和数据库表的字段对应
		private int id;
		private String loginName;
		private String password;
		private String name;// 用户姓名
		private int age;// 用户年龄
		private String sex;// 性别
		private Date birthday;// 生日
		private String address; // 地址
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getLoginName() {
			return loginName;
		}
		public void setLoginName(String loginName) {
			this.loginName = loginName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public Date getBirthday() {
			return birthday;
		}
		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", loginName=" + loginName + ", password=" + password + ", name=" + name
					+ ", age=" + age + ", sex=" + sex + ", birthday=" + birthday + ", address=" + address + "]";
		}
		
}
