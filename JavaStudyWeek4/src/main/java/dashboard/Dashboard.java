package dashboard;

import org.kohsuke.github.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.awt.datatransfer.*;
import java.util.List;

public class Dashboard {
    private GitHub github;
    private GHRepository repo;
    public String repoName;
    public int issuesSize;
    public List<Issue> issueList;
    public Map<String,User> userMap;
    public List<String>  userIdList;


    void connectGithub(String token) throws IOException{
        github = new GitHubBuilder().withOAuthToken(token).build();
        github.checkApiUrlValidity();
    }
    void selectRepo(String repoUrl) throws IOException{
        repo = github.getRepository(repoUrl);
        repoName = repo.getName();
    }
    void getIssueList() throws IOException{
        List<GHIssue> ghIssues = repo.getIssues(GHIssueState.ALL).stream().filter((issue)->issue.getTitle().contains("과제")).toList();
        issuesSize = ghIssues.size();
        issueList = new ArrayList<Issue>();
        for (GHIssue ghIssue : ghIssues) {
            issueList.add(new Issue(ghIssue));
        }
        issueList.sort((x, y) -> Integer.compare(x.week, y.week));

    }
    void getCommentLists() throws IOException{
        for (Issue issue : issueList) {
            issue.getCommentsList();
        }
    }
    void getUserList() throws IOException{
        userMap = new HashMap<String,User>();
        for (Issue issue : issueList) {
            for (String s : issue.commentIdList) {
                if(!userMap.containsKey(s)){
                    userMap.put(s,new User(issuesSize));
                }
                userMap.get(s).checkList.set(issue.week-1, Boolean.TRUE);
            }
        }
        userIdList = new ArrayList<String>(userMap.keySet());
        Collections.sort(userIdList);
    }
    void getUserRate() throws IOException{
        userMap.keySet().forEach((s)->userMap.get(s).setRate(issuesSize));
    }
    String makeTable(){
        String markText="";
        markText+="| 참여자 ("+userMap.size()+") ";
        for (int i = 1; i <= issuesSize; i++) {
            markText+="| "+i+"주차 ";
        }
        markText+="| 참석율 |\n";
        for (int i = 0; i < issuesSize; i++) {
            markText+="| --- ";
        }
        markText+="| --- | --- |\n";
        for (String userId : userIdList) {
            markText+="| "+userId;
            User user = userMap.get(userId);
            for (Boolean aBoolean : user.checkList) {
                markText+=aBoolean? "|:white_check_mark:" : "|";
            }
            markText+="| "+String.format("%.2f",user.rate)+"% |\n";
        }
        return markText;
    }
    void copyClipboard(String text){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        if(text != null)
        {
            StringSelection contents = new StringSelection(text);
            clipboard.setContents(contents, null);
        }
    }








}
