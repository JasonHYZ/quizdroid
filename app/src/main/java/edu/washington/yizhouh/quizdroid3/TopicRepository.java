package edu.washington.yizhouh.quizdroid3;


/**
 * Created by yizhouhuang on 5/11/15.
 */
public interface TopicRepository<String> {
    public void store(String elements);
    public void readJson(String fileName,Topic[] topic);
}
