package www.yunwen.androidsdk.mywebview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.List;

/**
 * Created by iyunwen on 2016/10/26.
 */

public class recycleview extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<String> urlData;

    public recycleview(Context context, List<String> urlData) {
        this.context = context;
        this.urlData = urlData;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.webview, parent, false);
        return new WebViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final MyWebView mWebview = ((WebViewHolder) holder).mWebview;
        mWebview.setHorizontalScrollBarEnabled(false);
        mWebview.setVerticalScrollBarEnabled(true);
        mWebview.setMaxHeight(500);
//        mWebview.loadUrl(urlData.get(holder.getAdapterPosition()));
        String s = "账户交易情况查询专卖店可通过点击<a class=\"linkwords\" target=\"_blank\" href=\"https://gbss.infinitus.com.cn/front;jsessionid=45F8FB6702A49007A0D15881311762A8#https%3A%2F%2Fgbss.infinitus.com.cn%2Fgbss-trade%2Ffront%2Fgbss-trade-ordermanager%2FstoreDetail%2Findex%3F_mid%3D115642%26mode%3Dnormal%26t%3D1448539209519\">e帆网菜单→我的明细账</a>（路径：我的账务-我的明细账）\n";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(
                "<!DOCTYPE html><html><head><style>img{max-width: 100%; width:auto; height: auto;}</style></head><body>");
        stringBuilder.append(s);
        stringBuilder.append("</body></html>");
        final String webHtml = stringBuilder.toString();
        mWebview.loadDataWithBaseURL("about:blank", webHtml, "text/html", "UTF-8", null);
        mWebview.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }

            @Override
            public void onScaleChanged(WebView view, float oldScale, float newScale) {
                super.onScaleChanged(view, oldScale, newScale);
                mWebview.setScaleSize(newScale);
            }
        });

    }

    @Override
    public int getItemCount() {
        return urlData.size();
    }

    private class WebViewHolder extends RecyclerView.ViewHolder {
        MyWebView mWebview;

        public WebViewHolder(View itemView) {
            super(itemView);
            mWebview = (MyWebView) itemView.findViewById(R.id.show_weview);
        }
    }

}
