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

package org.apache.sshd.client.kex;

import java.security.PublicKey;

import org.apache.sshd.client.session.ClientSession;
import org.apache.sshd.client.session.ClientSessionHolder;
import org.apache.sshd.common.kex.dh.AbstractDHKeyExchange;
import org.apache.sshd.common.session.Session;
import org.apache.sshd.common.util.ValidateUtils;

/**
 * @author <a href="mailto:dev@mina.apache.org">Apache MINA SSHD Project</a>
 */
public abstract class AbstractDHClientKeyExchange extends AbstractDHKeyExchange implements ClientSessionHolder {
    protected PublicKey serverKey;

    protected AbstractDHClientKeyExchange(Session session) {
        super(ValidateUtils.checkInstanceOf(session, ClientSession.class, "Using a client side KeyExchange on a server: %s", session));
    }

    @Override
    public final ClientSession getClientSession() {
        return (ClientSession) getSession();
    }

    @Override
    public PublicKey getServerKey() {
        return serverKey;
    }
}
