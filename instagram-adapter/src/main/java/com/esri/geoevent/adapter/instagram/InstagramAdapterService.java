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
