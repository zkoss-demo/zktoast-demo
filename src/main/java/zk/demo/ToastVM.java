package zk.demo;

import org.zkoss.addon.toast.Toast;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.util.*;
import org.zkoss.zul.*;

public class ToastVM {
	private ListModel<String> posm = new SimpleListModel<>(new String[] {
		"top_left", "top_center", "top_right",
		"middle_center", "middle_left", "middle_right",
		"bottom_left", "bottom_center", "bottom_right"
	}, true);

	private ListModel<String> types = new SimpleListModel<>(new String[] {
		Clients.NOTIFICATION_TYPE_INFO,
		Clients.NOTIFICATION_TYPE_WARNING,
		Clients.NOTIFICATION_TYPE_ERROR
	}, true);
	
	private ListModel<String> msgs = new SimpleListModel<>(new String[] {
		"(random)", "Protoss", "Force", "Beer", "HTML", "Deja vu", "Gate"
	}, true);

	private String[] msgsValue = new String[] {
		"En taro adun.",
		"Use the force, Harry.",
		"I don't always drink beer, but when I do, I code a lot.",
		"Also possible to do <em>HTML</em>.",
		"Deja vu! I've just been in this place before.",
		"El Psy Congroo."
	};

	private String position;
	private String type;
	private int messageIndex;
	private boolean durationEnabled = true;
	private int duration = 5000;
	private boolean closable = false;

	public ListModel<String> getPositionModel() {
		return this.posm;
	}

	public ListModel<String> getTypeModel() {
		return this.types;
	}

	public ListModel<String> getMessageModel() {
		return this.msgs;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMessageIndex() {
		return this.messageIndex;
	}

	public void setMessageIndex(int idx) {
		this.messageIndex = idx;
	}

	public boolean isDurationEnabled() {
		return this.durationEnabled;
	}

	public void setDurationEnabled(boolean enabled) {
		this.durationEnabled = enabled;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int value) {
		this.duration = value;
	}

	public boolean isClosable() {
		return this.closable;
	}

	public void setClosable(boolean closable) {
		this.closable = closable;
	}

	@Command
	public void showToast() {
		String msg = (messageIndex > 0)
			? msgsValue[messageIndex - 1]
			: msgsValue[(int) (Math.random() * msgsValue.length)];
		int dur = durationEnabled ? duration : -1;
		Toast.show(msg, type, position, dur, closable);
	}
}