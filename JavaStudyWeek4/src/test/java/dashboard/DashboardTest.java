package dashboard;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class DashboardTest {
    String token = "token";
    String repoUrl = "whiteship/live-study";
    Dashboard dashObject = new Dashboard();

    @Test
    void connectTest(){
        try{
            dashObject.connectGithub(token);
            System.out.println("GithubConnect success\n");

        }
        catch(Exception e){
            fail("connect Error (IOEXception)\n");
        }
    }

    @Test
    void repoTest(){
        try{
            connectTest();
            dashObject.selectRepo(repoUrl);
            assertNotNull(dashObject.repoName);
            System.out.println("selectRepository success");
            System.out.println("repo name : " +dashObject.repoName+"\n");
        }
        catch(Exception e){
            fail("repo Error (IOEXception)\n");
        }
    }

    @Test
    void issueRead(){
        try{
            repoTest();
            dashObject.getIssueList();
            System.out.println("issue Read from github Success");
            System.out.println("issue size : " +dashObject.issuesSize+"\n");
        }
        catch(Exception e){
            fail("issueRead Error (IOEXception)\n");
        }
    }

    @Test
    void getComments(){
        issueRead();
        for (Issue issue : dashObject.issueList) {
            try{
                issue.getCommentsList();
                System.out.println(issue.week+" week get success");
                System.out.println("ID List sieze: "+issue.commentIdList.size()+"\n");
                if(issue.week==2){
                    break;
                }
            }
            catch(Exception e){
                fail("getComments Error (WEEK :"+issue.week+")\n");
            }

        }

    }
    @Test
    void getUsers(){
        getComments();
        try{
            dashObject.getUserList();
            System.out.println("getUserList Success");
            System.out.println("User Number : " +dashObject.userMap.size()+"\n");
        }
        catch(Exception e){
            fail("getUsers Error (IOEXception)\n");
        }

    }

    @Test
    List<String> getRate(){
        getUsers();
        try{
            dashObject.getUserRate();
            System.out.println("getRate Success");
            List<String>  userIdList = new ArrayList<String>(dashObject.userMap.keySet());
            //List<String>  userIdList2 = dashObject.userMap.keySet().stream().toList();  //error
            Collections.sort(userIdList);
            //userIdList.forEach((id)-> System.out.println("user id : "+id+" rate : "+dashObject.userMap.get(id).rate));
            System.out.println("id Sort Success\n");
            return userIdList;
        }
        catch(Exception e){
            fail("getRate Error\n");
            return null;
        }
    }

    @Test
    void tableView(){
        List<String>  userIdList = getRate();
        String markText="";
        markText+="| 참여자 ("+dashObject.userMap.size()+") ";
        for (int i = 1; i <= dashObject.issuesSize; i++) {
            markText+="| "+i+"주차 ";
        }
        markText+="| 참석율 |\n";
        for (int i = 0; i < dashObject.issuesSize; i++) {
            markText+="| --- ";
        }
        markText+="| --- | --- |\n";
        for (String userId : userIdList) {
            markText+="| "+userId;
            User user = dashObject.userMap.get(userId);
            for (Boolean aBoolean : user.checkList) {
                markText+=aBoolean? "|:white_check_mark:" : "|";
            }
            markText+="| "+String.format("%.2f",user.rate)+"% |\n";
        }
        System.out.println(markText);



    }

    @Test
    void mainTest(){
        try{
            dashObject.connectGithub(token);
            System.out.println("GithubConnect\n");
            dashObject.selectRepo(repoUrl);
            assertNotNull(dashObject.repoName);
            System.out.println("repo name : " +dashObject.repoName+"\n");
            dashObject.getIssueList();
            System.out.println("issue size : " +dashObject.issuesSize+"\n");
            dashObject.getCommentLists();
            dashObject.getUserList();
            System.out.println("User Number : " +dashObject.userMap.size()+"\n");
            dashObject.getUserRate();
            dashObject.copyClipboard(dashObject.makeTable());
            System.out.println("Clipboard copied complete");
        }
        catch(Exception e){
            fail("make dashboard error");
        }
    }




}