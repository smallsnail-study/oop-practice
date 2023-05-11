package org.example;

public class User {

    private String password;

    public void initPassword(PasswordGenerator passwordGenerator) {    //패스워드 초기화
        // as-is 방식 (내부에서 생성 -> 강한 결합도)
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
//        String password = randomPasswordGenerator.generatePassword();
//        /**
//         * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
//         */
//        if (password.length() >= 8 && password.length() <= 12) {
//            this.password = password;
//        }

        // to-be 방식 (passwordGenerator 인터페이스를 이용 -> 느슨한 결합)
        String password = passwordGenerator.generatePassword();
        /**
         * 비밀번호는 최소 8자 이상 12자 이하여야 한다.
         */
        if (password.length() >= 8 && password.length() <= 12) {
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
