package com.guosun.meichat.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.View;
import android.widget.TextView;

import com.guosun.meichat.R;
import com.guosun.meichat.adapter.MovieAdapter;
import com.guosun.meichat.config.ConstsData;
import com.guosun.meichat.model.HttpResult;
import com.guosun.meichat.model.Subject;
import com.guosun.meichat.presenter.TopMoviePresenter;
import com.guosun.meichat.view.CustomRecyclerView;
import com.guosun.meichat.view.HorizontalDividerItemDecoration;
import com.guosun.meichat.view.VerticalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class BooksFragment extends BaseFragment implements TopMoviePresenter.TopMovieOnListener,View.OnClickListener {
    private CustomRecyclerView recyclerView_movie_list;
    private TextView change_type;
    private MovieAdapter mAdapter;
    private List<Subject> subjectList;
    private int currentMode;//0 默认listview  ， 1：gridview

    private VerticalDividerItemDecoration mVerticalDividerItemDecoration ;
    private HorizontalDividerItemDecoration mHorizontalDividerItemDecoration ;

    public static BooksFragment newInstance()
    {
        BooksFragment booksFragment = new BooksFragment();
        Bundle bundle = new Bundle();
        booksFragment.setArguments(bundle);
        return booksFragment;
    }


    @Override
    protected boolean showHeader() {
        return true;
    }

    @Override
    protected String getHeaderTitle() {
        return "我的书店";
    }

    @Override
    protected int getRootLayoutId() {
        return R.layout.fragment_books;
    }


    @Override
    protected void initUI(View view) {

        mVerticalDividerItemDecoration = new VerticalDividerItemDecoration.Builder(getActivity()).build();
        mHorizontalDividerItemDecoration = new HorizontalDividerItemDecoration.Builder(getActivity()).showLastDivider().build();
        recyclerView_movie_list = (CustomRecyclerView) view.findViewById(R.id.recyclerView_movie_list);
        change_type = (TextView) view.findViewById(R.id.change_type);
        change_type.setOnClickListener(this);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView_movie_list.setLayoutManager(mLayoutManager);
        recyclerView_movie_list.addItemDecoration(mHorizontalDividerItemDecoration);
        //如果确定每个item的内容不会改变RecyclerView的大小，设置这个选项可以提高性能
        recyclerView_movie_list.setHasFixedSize(true);
        subjectList = new ArrayList<>();
        currentMode = ConstsData.ViewModes.MODE_LIST;
        change_type.setText("我的书店");

    }

    @Override
    protected void initData() {
        super.initData();

    }

    @Override
    public void onSuccess(List<Subject> subject) {
        mAdapter = new MovieAdapter(getContext(),subject);
        recyclerView_movie_list.setAdapter(mAdapter);
        recyclerView_movie_list.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSuccessAll(HttpResult<List<Subject>> subject) {


    }


    @Override
    public void onClick(View v) {
        if(v == change_type){
//                BooksFragment topMovieFragment = BooksFragment.newInstance();
//                startFragmentWithPop(getChildFragmentManager(),R.id.fl_top_container,topMovieFragment);
        }
    }

}
