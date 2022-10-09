import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/*
    주민등록번호 생성기
 */
public class MemberNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MemberNumber mn = new MemberNumber();
        HashMap<String, String> user = new HashMap<String, String>();

        Random random = new Random();

        System.out.print("출생년도를 입력해 주세요. (yyyy): ");
        user.put("year", sc.next());

        System.out.print("출생월를 입력해 주세요. (mm): ");
        user.put("month", sc.next());

        System.out.print("출생일을 입력해 주세요. (dd) : ");
        user.put("day", sc.next());

        System.out.print("성별을 입력해 주세요. (m/f) : ");
        user.put("gender", sc.next());

        mn.getUserNumber(user);
    }

    /*
        주민번호 앞자리 생성
        @param user
        @return
     */
    public String preMemberNumber(HashMap user) {
        return user.get("year").toString().substring(2)
                + user.get("month") + user.get("day");
    }

    /*
        주민번호 뒷자리 생성
        @param user
        @return
     */
    public String suffixMemberNumber(HashMap user) {
        StringBuffer result = new StringBuffer();
        Random random = new Random();

        int IntYear = Integer.valueOf((String) user.get("year"));

        if(IntYear < 1900){ // 1900 년 이전
            result.append( "m".equals(user.get("gender")) ? "9" : "0" );
        }else if(IntYear < 2000){ // 2000 년 이전
            result.append( "m".equals(user.get("gender")) ? "1" : "2" );
        }else{ // 2000 년 이후
            result.append( "m".equals(user.get("gender")) ? "3" : "4" );
        }

        for(int i = 0; i < 6; i++){
            result.append( random.nextInt(10) );
        }

        return result.toString();
    } // suffixMemberNumber

    /*
        주민번호 생성
        @param user
     */
    private void getUserNumber(HashMap<String, String> user) {
        System.out.println( preMemberNumber(user) + "-" + suffixMemberNumber(user) );
    }

}
