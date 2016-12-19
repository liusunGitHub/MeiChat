package com.guosun.meichat.presenter;

import android.content.Context;

import com.guosun.meichat.http.ApiManager;
import com.guosun.meichat.model.HttpResult;
import com.guosun.meichat.model.Subject;
import com.guosun.meichat.subscribers.HttpOnNextListener;
import com.guosun.meichat.subscribers.ProgressSubscriber;

import java.util.List;

/**
 * Created by liuguosheng on 2016/12/5.
 */
public class TopMoviePresenter {
    private HttpOnNextListener<List<Subject>> getTopMovieSubjectOnNext;
    private HttpOnNextListener<HttpResult<List<Subject>>> getTopMovieAllOnNext;
    private ProgressSubscriber progressSubscriberAll;
    private ProgressSubscriber progressSubscriberSubject;
    private TopMovieOnListener mTopMovieOnListener;

    private Context context;

    public TopMoviePresenter(Context context) {
        this.context = context;

        getTopMovieSubjectOnNext = new HttpOnNextListener<List<Subject>>() {
            @Override
            public void onNext(List<Subject> subject) {
                if (mTopMovieOnListener != null) {
                    mTopMovieOnListener.onSuccess(subject);
                }
            }
        };
        getTopMovieAllOnNext = new HttpOnNextListener<HttpResult<List<Subject>>>() {
            @Override
            public void onNext(HttpResult<List<Subject>> subject) {
                if (mTopMovieOnListener != null) {
                    mTopMovieOnListener.onSuccessAll(subject);
                }
            }
        };
    }

    public void getMovieAllService() {
        progressSubscriberAll = new ProgressSubscriber<HttpResult<List<Subject>>>(getTopMovieAllOnNext, context, true);
        ApiManager.getInstance().getTopMovieAll(progressSubscriberAll, 0, 10);

    }

    public void getMovieSubjectService() {
        progressSubscriberSubject = new ProgressSubscriber<List<Subject>>(getTopMovieSubjectOnNext, context, true);
        ApiManager.getInstance().getTopMovieSubject(progressSubscriberSubject, 0, 10);
    }


    public void setTopMovieOnListener(TopMovieOnListener mTopMovieOnListener) {
        this.mTopMovieOnListener = mTopMovieOnListener;
    }

    public interface TopMovieOnListener {
        public void onSuccess(List<Subject> subject);
        public void onSuccessAll(HttpResult<List<Subject>> subject);
    }

}
