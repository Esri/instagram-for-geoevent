/*
  Copyright 1995-2013 Esri

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

  For additional information, contact:
  Environmental Systems Research Institute, Inc.
  Attn: Contracts Dept
  380 New York Street
  Redlands, California, USA 92373

  email: contracts@esri.com
 */

package com.esri.geoevent.adapter.instagram;

import javax.xml.bind.JAXBException;

import com.esri.ges.adapter.Adapter;
import com.esri.ges.adapter.AdapterServiceBase;
import com.esri.ges.adapter.util.XmlAdapterDefinition;
import com.esri.ges.core.component.ComponentException;

public class InstagramAdapterService extends AdapterServiceBase
{
	public InstagramAdapterService()
	{
		XmlAdapterDefinition xmlAdapterDefinition = new XmlAdapterDefinition(getResourceAsStream("adapter-definition.xml"));
		try
		{
			xmlAdapterDefinition.loadConnector(getResourceAsStream("input-connector-definition.xml"));
		}
		catch (JAXBException e)
		{
			throw new RuntimeException(e);
		}
		definition = xmlAdapterDefinition;

	}

	@Override
	public Adapter createAdapter() throws ComponentException
	{
		return new InstagramAdapter(definition);
	}

}
