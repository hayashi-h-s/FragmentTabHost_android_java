package com.haya.fragmenttabhostandroid_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTabHost;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
  // 参考サイト
// https://dev.classmethod.jp/articles/android-tips-38-fragment-tab-host/
//  TabSpec#setIndicator() です。これはタブの View になります。String を渡すとデフォルトのタブボタンの View が使われます。
//  最後に FragmentTabHost#addTab() でタブを追加します。
//
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //FragmentTabHost のIDを宣言
    FragmentTabHost host = (FragmentTabHost) findViewById(android.R.id.tabhost);
    // セット
    host.setup(this, getSupportFragmentManager(), R.id.content);

    // tabSpec1 の
    TabHost.TabSpec tabSpec1 = host.newTabSpec("tab1");
    Button button1 = new Button(this);
    button1.setBackgroundResource(R.drawable.ic_baseline_account_balance_24);
    //http://y-anz-m.blogspot.com/2010/11/andoridtabwidget.html
    tabSpec1.setIndicator(button1);
    Bundle bundle1 = new Bundle();
    // 情報を渡している
    bundle1.putString("name", "Tab1だよ。どーも。");
    // SampleFragment のデータをhostに追加
    host.addTab(tabSpec1, SampleFragment.class, bundle1);

    // newTabSpec インスタンス
    TabHost.TabSpec tabSpec2 = host.newTabSpec("tab2");
    Button button2 = new Button(this);
    button2.setBackgroundResource(R.drawable.tab_cennter);
    // タブの View
    tabSpec2.setIndicator(button2);
    // フラグメントに渡す情報
    Bundle bundle2 = new Bundle();
    bundle2.putString("name", "Tab2");

    host.addTab(tabSpec2, SampleFragment.class, bundle2);

    TabHost.TabSpec tabSpec3 = host.newTabSpec("tab3");
    Button button3 = new Button(this);
    button3.setBackgroundResource(R.drawable.tab_left);
    tabSpec3.setIndicator(button3);
    Bundle bundle3 = new Bundle();
    bundle3.putString("name", "Tab3");
    host.addTab(tabSpec3, SampleFragment.class, bundle3);
  }

  // フラグメントを作成しているクラス
  public static class SampleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

      TextView textView = new TextView(getActivity());
      textView.setGravity(Gravity.CENTER);

      // bundleで渡した情報をセットしている
      textView.setText(getArguments().getString("name"));

      return textView;
    }

  }
}