
import java.util.HashSet;
import java.util.Set;

/*  1.
    *일 때, 비교될 경우는 pass
    *이 아닐 때, 알파벳이 다르면 바로 break; 제외
    *이 아닐 때, 알파벳이 전부 같으면 cnt+=1;
    
    2. 
    제외 되었을 경우, 다른 banned_id에서 한번 더 제외 될 수 있음.
    다른 배열에 저장했다가 따로 한번 더 비교 후 cnt -= 1;
    or set에 저장

    * 조합이였네요.. 어쩐지 쉽다생각했어요..
    혼자서 다시 풀어보겠습니다,,, 어떻게 풀어야할까요?
*/
class Solution {

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        Set<String> resultset = new HashSet<String>();
        for(int i = 0; i < user_id.length; i++){
            for(int j = 0; j < banned_id.length; j++){
                //1. 길이 비교
                if(user_id[i].length() != banned_id[j].length()){
                    continue;
                }
                //2. 길이가 같은 경우, 값 하나씩 비교
                int alpha = 0;
                int star = 0;
                for(int k = 0; k < user_id[i].length(); k++){
                    // *인 경우는 pass
                    if(banned_id[j].charAt(k) == '*'){
                        star += 1;
                    } else if (user_id[i].charAt(k) == banned_id[j].charAt(k)) {
                        alpha += 1;
                    }

                    if (star+alpha == user_id[i].length()){
                        resultset.add(user_id[i]);
                    }

                }
            }
        }

        answer = resultset.size();
        return answer;
    }
}