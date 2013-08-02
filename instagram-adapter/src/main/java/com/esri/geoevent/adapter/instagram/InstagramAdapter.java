package com.esri.geoevent.adapter.instagram;

import java.nio.ByteBuffer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.esri.ges.adapter.AdapterDefinition;
import com.esri.ges.adapter.InboundAdapterBase;
import com.esri.ges.core.component.ComponentException;
import com.esri.ges.core.geoevent.GeoEvent;

public class InstagramAdapter extends InboundAdapterBase {
	private static final Log LOG = LogFactory.getLog(InstagramAdapter.class);

	public InstagramAdapter(AdapterDefinition definition)
			throws ComponentException {
		super(definition);
		LOG.debug("Instagram Status Adapter created");
	}

	public static void consoleDebugPrintLn(String msg) {
		String consoleOut = System.getenv("GEP_CONSOLE_OUTPUT");
		if (consoleOut != null && "1".equals(consoleOut)) {
			System.out.println(msg);
		}
	}

	public static void consoleDebugPrint(String msg) {
		String consoleOut = System.getenv("GEP_CONSOLE_OUTPUT");
		if (consoleOut != null && "1".equals(consoleOut)) {
			System.out.print(msg);
		}
	}

	@Override
	protected GeoEvent adapt(ByteBuffer arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}
}
