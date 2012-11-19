/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rex.accmeter;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toast;

public class ActivityMain extends TabActivity {

	static final private boolean DEBUG = true;
	static final private String TAG = "RexLog";
	
	private long mExitTime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (DEBUG) Log.v(TAG, "ActivityMain::onCreate");
		
        final TabHost tabHost = getTabHost();

        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator(getResources().getString(R.string.tab_gpad))
                .setContent(new Intent(this, ActivityTabGPad.class)));

        tabHost.addTab(tabHost.newTabSpec("tab2")
                .setIndicator(getResources().getString(R.string.tab_graph))
                .setContent(new Intent(this, ActivityTabGraph.class)));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {	
		//if (DEBUG) Log.v(TAG, "ActivityMain::onCreateOptionsMenu");
		getMenuInflater().inflate(R.menu.activity_main_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (DEBUG) Log.v(TAG, "ActivityMain::onOptionsItemSelected itemId:" + item.getItemId());
		switch (item.getItemId()) {
		case R.id.menu_setting:
			startActivity(new Intent(this, ActivitySettings.class));
			break;
		case R.id.menu_about:
			startActivity(new Intent(this, ActivityAbout.class));
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBackPressed() {
		if (DEBUG) Log.v(TAG, "ActivityMain::onBackPressed");
		if (System.currentTimeMillis() - mExitTime > 2000) {
			Toast.makeText(getApplicationContext(), R.string.toast_quit, Toast.LENGTH_SHORT).show();
			mExitTime = System.currentTimeMillis();
		} else {
			finish();
		}
	}
}
