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

public class TopMovieFragment extends BaseFragment implements TopMoviePresenter.TopMovieOnListener,View.OnClickListener {
    private CustomRecyclerView recyclerView_movie_list;
    private TextView change_type;
    private MovieAdapter mAdapter;
    private List<Subject> subjectList;
    private int currentMode;//0 默认listview  ， 1：gridview

    private VerticalDividerItemDecoration mVerticalDividerItemDecoration ;
    private HorizontalDividerItemDecoration mHorizontalDividerItemDecoration ;

    public static TopMovieFragment newInstance()
    {
        TopMovieFragment topMovieFragment = new TopMovieFragment();
        Bundle bundle = new Bundle();
        topMovieFragment.setArguments(bundle);
        return topMovieFragment;
    }


    @Override
    protected boolean showHeader() {
        return true;
    }

    @Override
    protected String getHeaderTitle() {
        return "Top250";
    }

    @Override
    protected int getRootLayoutId() {
        return R.layout.fragment_top_movie;
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
        change_type.setText("切换为网格");

    }

    @Override
    protected void initData() {
        super.initData();
        TopMoviePresenter mTopMoviePresenter = new TopMoviePresenter(getActivity());
        mTopMoviePresenter.setTopMovieOnListener(this);
        mTopMoviePresenter.getMovieSubjectService();

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
            if(mAdapter==null){
                return;
            }
            if (currentMode == ConstsData.ViewModes.MODE_LIST) {


                BooksFragment booksFragment = BooksFragment.newInstance();
                startWithPop(booksFragment);

//                startFragmentWithPop(booksFragment);

//                BooksFragment topMovieFragment = BooksFragment.newInstance();
//                startFragment(getChildFragmentManager(),R.id.fl_top_container,topMovieFragment);
//                GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
//                mAdapter.setViewMode(ConstsData.ViewModes.MODE_GRID);
//                recyclerView_movie_list.removeItemDecoration(mHorizontalDividerItemDecoration);
//                recyclerView_movie_list.removeItemDecoration(mVerticalDividerItemDecoration);
//                recyclerView_movie_list.addItemDecoration(mVerticalDividerItemDecoration);
//                recyclerView_movie_list.addItemDecoration(mHorizontalDividerItemDecoration);
//                recyclerView_movie_list.switchLayoutManager(manager);
//                recyclerView_movie_list.setAdapter(mAdapter);
//                change_type.setText("切换为列表");
//                currentMode = ConstsData.ViewModes.MODE_GRID;
            } else if (currentMode == ConstsData.ViewModes.MODE_GRID){
//                LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
//                mAdapter.setViewMode(ConstsData.ViewModes.MODE_LIST);
//                recyclerView_movie_list.removeItemDecoration(mHorizontalDividerItemDecoration);
//                recyclerView_movie_list.removeItemDecoration(mVerticalDividerItemDecoration);
//                recyclerView_movie_list.addItemDecoration(mHorizontalDividerItemDecoration);
//                recyclerView_movie_list.switchLayoutManager(mLayoutManager);
//                recyclerView_movie_list.setAdapter(mAdapter);
//                change_type.setText("切换为网格");
//                currentMode = ConstsData.ViewModes.MODE_LIST;
            }

        }
    }

}
