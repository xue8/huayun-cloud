package cn.ddnd.huayun.es.pojo;

import java.io.Serializable;

public class ElasticsearchResponse  implements Serializable {
    Object took;
    Object timedOut;
    Object shards;
    Object hits;

    public Object getTook() {
        return took;
    }

    public void setTook(Object took) {
        this.took = took;
    }

    public Object getTimedOut() {
        return timedOut;
    }

    public void setTimedOut(Object timedOut) {
        this.timedOut = timedOut;
    }

    public Object getShards() {
        return shards;
    }

    public void setShards(Object shards) {
        this.shards = shards;
    }

    public Object getHits() {
        return hits;
    }

    public void setHits(Object hits) {
        this.hits = hits;
    }
}
