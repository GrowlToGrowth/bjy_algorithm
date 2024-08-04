import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    set을 이용
*/
class Solution {


    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        int u_len = user_id.length;
        int b_len = banned_id.length;
        List<Set<String>> ban_list = new ArrayList<>();

        for(String ban : banned_id){
            Set<String> matchedSet = new HashSet<>();
            for(String user : user_id){
                if(isMatched(ban,user)){
                    matchedSet.add(user);
                }
            }
            ban_list.add(matchedSet);
        }

        Set<Set<String>> resultSet = new HashSet<>();

        dfs(ban_list,new HashSet<>(),0,resultSet);
        answer = resultSet.size();
        return answer;
    }

    static void dfs(List<Set<String>> ban_list, Set<String> currentSet, int index, Set<Set<String>> resultSet){
        if(index == ban_list.size()){
            resultSet.add(new HashSet<>(currentSet));
            return;
        }
        for (String user : ban_list.get(index)){
            if(!currentSet.contains(user)){
                currentSet.add(user);
                dfs(ban_list, currentSet, index + 1 , resultSet);
                currentSet.remove(user);
            }
        }

    }

    static boolean isMatched(String ban, String user){
        int star = 0;
        int alpha = 0;
        //길이 검사
        if (ban.length() != user.length()){
            return false;
        }
        //하나씩 검사
        for(int i = 0; i < ban.length(); i++){
            if(ban.charAt(i) == '*'){
                star += 1;
            }
            else if(ban.charAt(i) == user.charAt(i)){
                alpha += 1;
            }

        }

        return star + alpha == ban.length();
    }
}
