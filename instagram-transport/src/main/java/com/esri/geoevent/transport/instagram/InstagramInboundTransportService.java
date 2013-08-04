package com.esri.geoevent.transport.instagram;

import com.esri.ges.core.component.ComponentException;
import com.esri.ges.transport.Transport;
import com.esri.ges.transport.http.HttpInboundTransportService;
import com.esri.ges.transport.util.XmlTransportDefinition;

public class InstagramInboundTransportService extends HttpInboundTransportService 
{
	public InstagramInboundTransportService() 
	{
		super();
		definition = new XmlTransportDefinition(
				getResourceAsStream("instagram-inboundtransport-definition.xml"),
				super.definition);
	}

	public Transport createTransport() throws ComponentException 
	{
		return new InstagramInboundTransport(definition);
	}
}
