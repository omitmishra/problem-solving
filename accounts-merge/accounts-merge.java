class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
     HashMap<String, String> emailUserMap = new HashMap<>();
        HashMap<String, HashSet<String>> emailAdjMap = new HashMap<>();
        
        for(List<String> account: accounts) {
            String userName = account.get(0);
            if(account.size() == 2) {
                emailUserMap.put(account.get(1), userName);
                emailAdjMap.put(account.get(1), new HashSet<>());
            } else {
               for(int i = 1; i<account.size(); i++) {
                    for(int j = i+1; j<account.size(); j++) {
                        HashSet<String> adj1 = emailAdjMap.getOrDefault(account.get(i), new HashSet<>());
                        adj1.add(account.get(j));
                        emailAdjMap.put(account.get(i), adj1);

                        HashSet<String> adj2 = emailAdjMap.getOrDefault(account.get(j), new HashSet<>());
                        adj2.add(account.get(i));
                        emailAdjMap.put(account.get(j), adj2);

                        emailUserMap.put(account.get(i), userName);
                        emailUserMap.put(account.get(j), userName);
                    }
                } 
            }
            
        }
        
        
        HashSet<String> visitedEmail = new HashSet<>();
        List<List<String>> answer = new ArrayList<>();
        
        for(Map.Entry<String, HashSet<String>> val: emailAdjMap.entrySet()) {
            if(!visitedEmail.contains(val.getKey())) {
                List<String> subAnswer = new ArrayList<>();
                dfs(emailAdjMap, val.getKey(), visitedEmail, subAnswer);
                Collections.sort(subAnswer);
                subAnswer.add(0, emailUserMap.get(val.getKey()));
                answer.add(new ArrayList<>(subAnswer));
            }
        }
        
        return answer;
    }
    
    
    
    void dfs(HashMap<String, HashSet<String>> emailAdjMap, String currentEmail, HashSet<String> visited, List<String> subAnswer) {
        subAnswer.add(currentEmail);
        visited.add(currentEmail);
        
        for(String adjEmails: emailAdjMap.get(currentEmail)) {
            if(!visited.contains(adjEmails)) {
               dfs(emailAdjMap, adjEmails, visited, subAnswer); 
            }
        }
        
    }
}