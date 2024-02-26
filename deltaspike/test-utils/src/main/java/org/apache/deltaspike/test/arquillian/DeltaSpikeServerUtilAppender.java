/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.deltaspike.test.arquillian;

import org.apache.deltaspike.test.category.DeltaSpikeTest;
import org.apache.deltaspike.test.utils.Serializer;
import org.jboss.arquillian.container.test.spi.client.deployment.CachedAuxilliaryArchiveAppender;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;

import static org.apache.deltaspike.test.utils.BeansXmlUtil.BEANS_XML_ALL;

public class DeltaSpikeServerUtilAppender extends CachedAuxilliaryArchiveAppender
{
    @Override
    protected Archive<?> buildArchive()
    {
        return ShrinkWrap.create(JavaArchive.class, "test-utils.jar")
                .addPackage(Serializer.class.getPackage())
                .addPackage(DeltaSpikeTest.class.getPackage())
                .addAsManifestResource(BEANS_XML_ALL, "beans.xml");
    }
}
