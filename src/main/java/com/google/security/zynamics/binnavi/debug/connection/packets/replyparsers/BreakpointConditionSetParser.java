// Copyright 2011-2016 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.security.zynamics.binnavi.debug.connection.packets.replyparsers;

import com.google.security.zynamics.binnavi.debug.connection.DebugCommandType;
import com.google.security.zynamics.binnavi.debug.connection.interfaces.ClientReader;
import com.google.security.zynamics.binnavi.debug.connection.packets.replies.BreakpointConditionSetReply;

import java.io.IOException;

/**
 * Parser responsible for parsing replies to Set Breakpoint Condition requests.
 */
public final class BreakpointConditionSetParser
    extends AbstractReplyParser<BreakpointConditionSetReply> {
  /**
   * Creates a new Set Breakpoint Condition reply parser.
   *
   * @param clientReader Used to read messages sent by the debug client.
   */
  public BreakpointConditionSetParser(final ClientReader clientReader) {
    super(clientReader, DebugCommandType.RESP_SET_BREAKPOINT_CONDITION_SUCC);
  }

  @Override
  protected BreakpointConditionSetReply parseError(final int packetId) throws IOException {
    final int errorCode = parseInteger();
    return new BreakpointConditionSetReply(packetId, errorCode);
  }

  @Override
  public BreakpointConditionSetReply parseSuccess(final int packetId, final int argumentCount) {
    return new BreakpointConditionSetReply(packetId, 0);
  }
}
