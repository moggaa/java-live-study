package dashboard;

import java.io.IOException;
import java.util.*;
import org.kohsuke.github.*;

public class Issue {
    GHIssue apiObject ;
    int week;
    List<String> commentIdList = new ArrayList<String>();
    Issue(GHIssue apiObject) throws IOException {
        this.apiObject = apiObject;
        this.week = Integer.parseInt(this.apiObject.getTitle().replaceAll("[^0-9]", ""));
    }
    List<String> getCommentsList() throws IOException{
        List<GHIssueComment> comments=apiObject.getComments();
        for (GHIssueComment comment : comments) {
            commentIdList.add(comment.getUser().getLogin());
        }
        return commentIdList;
    }

    @Override
    public String toString(){
        return week+"week Issue Object";
    }


}
