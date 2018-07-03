package com.zpc.lottery;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.zpc.lottery.adapter.AdapterX;
import com.zpc.lottery.beas.BaseX;
import com.zpc.lottery.beas.TrendData;
import com.zpc.lottery.ui.DDTrendChart;
import com.zpc.lottery.ui.LottoTrendView;
import com.zpc.lottery.utils.Drawl;
import com.zpc.lottery.utils.XListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


public class MainActivity extends AppCompatActivity implements DDTrendChart.ISelectedChangeListener {

    public static ArrayList<TrendData> lists;
    private XListView xlistview;
    private AdapterX adapterX;
    private LinearLayout linear;
    private LottoTrendView mTrendView;
    final int maxSignleNum = 9;
    private DDTrendChart mTrendChart;
    private List<BaseX> baseXList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//        LinearLayout parent = (LinearLayout) inflater.inflate(R.layout.activity_main, null);
//        setContentView(parent);
        lists = new ArrayList<>();
        baseXList = new ArrayList<>();
        initViews();
        httpPost2();
    }

    private void initViews() {
        this.mTrendView = (LottoTrendView) findViewById(R.id.ltv_trendView);
        this.mTrendChart = new DDTrendChart(this, this.mTrendView);
        this.mTrendView.setChart(this.mTrendChart);
        this.mTrendChart.setShowYilou(true);
        this.mTrendChart.setDrawLine(true);
        this.mTrendChart.setSelectedChangeListener(this);
    }


    private void httpPost2() {
        final String path = "http://tubiao.baibaocp.com/syxw/table?cdkey=123456&lotid=10118&num=10&tid=1&tag=1";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(path, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String s) {
                super.onSuccess(s);
                String s1 = s;
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    String msg = jsonObject.getString("msg");
                    String data = jsonObject.getString("data");
                    if (msg.equals("success")) {
                        JSONObject jsonObject1 = new JSONObject(data);
                        JSONArray jsonArray = jsonObject1.getJSONArray("table");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            BaseX baseX = new Gson().fromJson(jsonArray.getString(i), BaseX.class);
                            baseXList.add(baseX);
                        }
                        setDate(baseXList);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    StringBuffer stringBuffer = new StringBuffer();
    StringBuffer stringBuffer1 = new StringBuffer();
    private void setDate(List<BaseX> list) {
        for (int i = 0; i < list.size(); i++) {
            stringBuffer.setLength(0);
            stringBuffer1.setLength(0);
            stringBuffer.append(list.get(i).getB_1() + ",");
            stringBuffer.append(list.get(i).getB_2() + ",");
            stringBuffer.append(list.get(i).getB_3() + ",");
            stringBuffer.append(list.get(i).getB_4() + ",");
            stringBuffer.append(list.get(i).getB_5() + ",");
            stringBuffer.append(list.get(i).getB_6() + ",");
            stringBuffer.append(list.get(i).getB_7() + ",");
            stringBuffer.append(list.get(i).getB_8() + ",");
            stringBuffer.append(list.get(i).getB_9() + ",");
            stringBuffer.append(list.get(i).getB_10() + ",");
            stringBuffer.append(list.get(i).getB_11());
            if (list.get(i).getBall1().equals("01")) {
                stringBuffer1.append(list.get(i).getBall1() + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
            } else if (list.get(i).getBall1().equals("02")) {
                stringBuffer1.append("" + ",");
                stringBuffer1.append(list.get(i).getBall1() + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
            } else if (list.get(i).getBall1().equals("03")) {
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append(list.get(i).getBall1() + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
            } else if (list.get(i).getBall1().equals("04")) {
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append(list.get(i).getBall1() + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
            } else if (list.get(i).getBall1().equals("05")) {
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append(list.get(i).getBall1() + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
            } else if (list.get(i).getBall1().equals("06")) {
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append(list.get(i).getBall1() + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
            } else if (list.get(i).getBall1().equals("07")) {
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append(list.get(i).getBall1() + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
            } else if (list.get(i).getBall1().equals("08")) {
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append(list.get(i).getBall1() + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
            } else if (list.get(i).getBall1().equals("09")) {
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append(""+ ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append(list.get(i).getBall1() + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
            } else if (list.get(i).getBall1().equals("10")) {
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append(""+ ",");
                stringBuffer1.append(list.get(i).getBall1() + ",");
                stringBuffer1.append("" + ",");
            } else if (list.get(i).getBall1().equals("11")) {
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append("" + ",");
                stringBuffer1.append(list.get(i).getBall1() + ",");
            }
            TrendData trendData = new TrendData();
            trendData.setType("row");
            trendData.setPid(list.get(i).getIssue());
            trendData.setRed(stringBuffer.toString());
            trendData.setBlue(stringBuffer1.toString());
            MainActivity.lists.add(trendData);
        }
        MainActivity.this.mTrendChart.updateData("01", (ArrayList) MainActivity.lists);
    }

    int l[] = {0, 0};
    int l1[] = {0, 0};

    private void setInfo(List<BaseX> list) {
        for (int i = 0; i < list.size(); i++) {
            LinearLayout.LayoutParams lp_LinearLayout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//            lp_LinearLayout.gravity= Gravity.LEFT;
            TextView text1 = new TextView(this);
            String text = list.get(i).getBall1();
            if (text.equals("01")) {
                text1.setBackgroundColor(Color.parseColor("#bce672"));
                text1.setText(text);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(0, 22 * i, 0, 0);
                text1.setLayoutParams(lp);

            } else if (text.equals("02")) {
                text1.setBackgroundColor(Color.parseColor("#c9dd22"));
                text1.setText(text);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(22, 22 * i, 0, 0);
                text1.setLayoutParams(lp);


            } else if (text.equals("03")) {
                text1.setBackgroundColor(Color.parseColor("#bddd22"));
                text1.setText(text);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(22 * 1, 22 * i, 0, 0);
                text1.setLayoutParams(lp);

            } else if (text.equals("04")) {
                text1.setBackgroundColor(Color.parseColor("#afdd22"));
                text1.setText(text);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(22 * 2, 22 * i, 0, 0);
                text1.setLayoutParams(lp);

            } else if (text.equals("05")) {
                text1.setBackgroundColor(Color.parseColor("#a3d900"));
                text1.setText(text);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(22 * 3, 22 * i, 0, 0);
                text1.setLayoutParams(lp);

            } else if (text.equals("06")) {
                text1.setBackgroundColor(Color.parseColor("#9ed900"));
                text1.setText(text);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(22 * 4, 22 * i, 0, 0);
                text1.setLayoutParams(lp);

            } else if (text.equals("07")) {
                text1.setBackgroundColor(Color.parseColor("#9ed048"));
                text1.setText(text);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(22 * 5, 22 * i, 0, 0);
                text1.setLayoutParams(lp);

            } else if (text.equals("08")) {
                text1.setBackgroundColor(Color.parseColor("#96ce54"));
                text1.setText(text);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(22 * 6, 22 * i, 0, 0);
                text1.setLayoutParams(lp);

            } else if (text.equals("09")) {
                text1.setBackgroundColor(Color.parseColor("#00bc12"));
                text1.setText(text);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(22 * 7, 22 * i, 0, 0);
                text1.setLayoutParams(lp);

            } else if (text.equals("10")) {
                text1.setBackgroundColor(Color.parseColor("#0eb83a"));
                text1.setText(text);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(22 * 8, 22 * i, 0, 0);
                text1.setLayoutParams(lp);

            } else if (text.equals("11")) {
                text1.setBackgroundColor(Color.parseColor("#0aa344"));
                text1.setText(text);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                lp.setMargins(22 * 9, 22 * i, 0, 0);
                text1.setLayoutParams(lp);

            }
            linear.addView(text1);
        }
        traversalView(linear);
    }


    /**
     * 遍历所有view
     *
     * @param viewGroup
     */
    public void traversalView(ViewGroup viewGroup) {
        int count = viewGroup.getChildCount();
        for (int i = 0; i < count; i++) {
            final View view = viewGroup.getChildAt(i);
            if (view instanceof ViewGroup) {
                traversalView((ViewGroup) view);
            } else {
                ViewTreeObserver vto = view.getViewTreeObserver();
                vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        /* 获取子控件信息 */
                        view.getLocationInWindow(l);
                        drawer(1030, 138, 1118, 217);
                        l1 = l;
                    }
                });

            }
        }
    }


    private void drawer(int startX, int startY, int stopX, int stopY) {
        Drawl drawer = new Drawl(this, startX, startY, stopX, stopY);
        drawer.invalidate();
        linear.addView(drawer);
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Override
    public void onSelectedChange(TreeSet<Integer> treeSet, TreeSet<Integer> treeSet2) {

    }
}
