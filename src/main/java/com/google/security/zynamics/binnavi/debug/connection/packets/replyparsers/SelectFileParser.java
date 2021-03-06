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
import com.google.security.zynamics.binnavi.debug.connection.packets.replies.SelectFileReply;

import java.io.IOException;

/**
 * Parser responsible for parsing replies to Select File requests.
 */
public final class SelectFileParser extends AbstractReplyParser<SelectFileReply> {
  /**
   * Creates a new Select File reply parser.
   *
   * @param clientReader Used to read messages sent by the debug client.
   */
  public SelectFileParser(final ClientReader clientReader) {
    super(clientReader, DebugCommandType.RESP_SELECT_FILE_SUCC);
  }

  @Override
  protected SelectFileReply parseError(final int packetId) throws IOException {
    return new SelectFileReply(packetId, parseInteger());
  }

  @Override
  protected SelectFileReply parseSuccess(final int packetId, final int argumentCount) {
    return new SelectFileReply(packetId, 0);
  }
}
