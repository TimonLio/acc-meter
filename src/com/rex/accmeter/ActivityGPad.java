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

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import com.rex.accmeter.R;

public class ActivityGPad extends Activity {

	static final private boolean DEBUG = true;
	static final private String TAG = "RexLog";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (DEBUG) Log.v(TAG, "ActivityGPad::onCreate");
		
		setContentView(R.layout.activity_gpad);
	}
	
}
