/*
 * Copyright 2014 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.doubleclick.openrtb;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import com.google.protos.adx.NetworkBid.BidRequest.Video.CompanionSlot.CreativeFormat;

import org.junit.Test;

public class BannerMimeMapperTest {
  @Test
  public void testMapper() {
    assertThat(BannerMimeMapper.toOpenRtb(ImmutableList.of(CreativeFormat.IMAGE_CREATIVE), null))
        .containsExactly("image/gif", "image/jpeg", "image/png");
    assertThat(BannerMimeMapper.toDoubleClick(ImmutableList.of("image/jpeg"), null))
        .containsExactly(CreativeFormat.IMAGE_CREATIVE);
  }
}
