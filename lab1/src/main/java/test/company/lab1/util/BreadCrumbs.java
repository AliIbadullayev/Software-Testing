package test.company.lab1.util;

public class BreadCrumbs {

    private String trace = "";

    public String getTrace() {
        return trace;
    }

    public void pollQueueCrumb(Integer crumb){
        trace += "poll" + crumb.toString();
    }

    public void addQueueCrumb(Integer crumb){
        trace += "add" + crumb.toString();
    }

    public void clearTrace(){
        trace = "";
    }
}
