package org.pjsip.pjsua2;

import java.io.File;
import java.util.ArrayList;
import org.pjsip.pjsua2.*;
public class MyBuddy extends Buddy {
	public BuddyConfig cfg;
	
	public MyBuddy(BuddyConfig config) {
		super();
		cfg = config;
	}
	
	public String getStatusText() {
		BuddyInfo bi;
		
		try {
			bi = getInfo();
		} catch (Exception e) {
			return "?";
		}
		
		String status = "";
		if (bi.getSubState() == pjsip_evsub_state.PJSIP_EVSUB_STATE_ACTIVE) {
			if (bi.getPresStatus().getStatus() == pjsua_buddy_status.PJSUA_BUDDY_STATUS_ONLINE) {
				status = bi.getPresStatus().getStatusText();
				if (status == null || status.isEmpty()) {
					status = "Online";
				}
			} else if (bi.getPresStatus().getStatus() == pjsua_buddy_status.PJSUA_BUDDY_STATUS_OFFLINE) {
				status = "Offline";
			} else {
				status = "Unknown";
			}
		}
		return status;
	}

	@Override
	public void onBuddyState() {
		
	}
	
}

