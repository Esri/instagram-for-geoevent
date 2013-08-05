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

package com.esri.geoevent.transport.instagram;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.esri.ges.core.component.ComponentException;
import com.esri.ges.core.component.RunningState;
import com.esri.ges.transport.TransportContext;
import com.esri.ges.transport.TransportDefinition;
import com.esri.ges.transport.http.HttpInboundTransport;

public class InstagramInboundTransport extends HttpInboundTransport
{
  private static final Log logger = LogFactory.getLog(InstagramInboundTransport.class);

  private String           clientId;
  private String           clientSecret;

  public InstagramInboundTransport(TransportDefinition definition) throws ComponentException
  {
    super(definition);
  }

  @Override
  public synchronized void start()
  {
    super.start();
    logger.debug("Instagram-Inbound started.");
  }

  @Override
  public synchronized void stop()
  {
    super.stop();
    logger.debug("Instagram-Inbound stopped.");
  }

  @Override
  public synchronized void setup()
  {
    super.setup();
    try
    {
      applyProperties();
    }
    catch (Exception e)
    {
      logger.error(e.getMessage(), e);
    }
  }

  @Override
  public void validate()
  {
    logger.debug("Inbound Skip validation...");
  }

  @Override
  public void onReceive(TransportContext context)
  {
    super.onReceive(context);
    consoleDebugPrintLn("onReceive");
  }

  @Override
  public synchronized boolean isRunning()
  {
    return (getRunningState() == RunningState.STARTED);
  }

  public void applyProperties() throws Exception
  {
    if (getProperty("client_id").isValid())
    {
      String value = (String) getProperty("client_id").getValue();
      if (value.length() > 0)
      {
        clientId = value;
      }
    }
    if (getProperty("client_secret").isValid())
    {
      String value = (String) getProperty("client_secret").getValue();
      if (value.length() > 0)
      {
        clientSecret = value;
      }
    }
    clientUrl += "?client_id=" + clientId + "&client_secret=" + clientSecret;
  }

  public static void consoleDebugPrintLn(String msg)
  {
    String consoleOut = System.getenv("GEP_CONSOLE_OUTPUT");
    if (consoleOut != null && "1".equals(consoleOut))
    {
      System.out.println(msg);
      logger.debug(msg);
    }
  }

  public static void consoleDebugPrint(String msg)
  {
    String consoleOut = System.getenv("GEP_CONSOLE_OUTPUT");
    if (consoleOut != null && "1".equals(consoleOut))
    {
      System.out.print(msg);
      logger.debug(msg);
    }
  }

}
