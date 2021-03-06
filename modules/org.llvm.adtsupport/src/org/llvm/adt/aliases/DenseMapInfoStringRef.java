/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.llvm.adt.aliases;

import org.clank.support.Converted;
import org.llvm.adt.DenseMapInfo;
import org.clank.support.*;

/**
 * class used to manage keys in Set/Map collections.
 * DenseMapInfo<StringRef> specialization.
 *
 * @author Petr Kudryavtsev <petrk@netbeans.org>
 * @author Vladimir Voskresensky
 */
//<editor-fold defaultstate="collapsed" desc="<anonymous namespace>::PTHStringLookupTrait">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/DenseMapInfo.h", line = 23,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -filter=llvm::DenseMapInfo")
//</editor-fold>
public class DenseMapInfoStringRef implements DenseMapInfo<org.llvm.adt.StringRef>{
  private static final DenseMapInfoStringRef $INFO = new DenseMapInfoStringRef();
  
  private final boolean allowCompareWithEmptyAndTombstone;
  protected final Object emptyKey;
  protected final Object tombstoneKey;
  
  public static  DenseMapInfoStringRef $Info() {
    return $INFO;
  }

  public DenseMapInfoStringRef() {
    this(new org.llvm.adt.StringRef(), new org.llvm.adt.StringRef());
  }
  public DenseMapInfoStringRef(Object emptyKey, Object tombstoneKey) {
    this(emptyKey, tombstoneKey, false);
  }
  public DenseMapInfoStringRef(Object emptyKey, Object tombstoneKey, boolean allowCompareWithEmptyAndTombstone) {
    this.emptyKey = emptyKey;
    this.tombstoneKey = tombstoneKey;
    this.allowCompareWithEmptyAndTombstone = allowCompareWithEmptyAndTombstone;
    assert this.tombstoneKey != this.emptyKey : "emptyKey [" + this.emptyKey + "] must be different from tombstoneKey [" + this.tombstoneKey + "]";
    assert (emptyKey != null) : "emptyKey marker must be non null";
    assert (tombstoneKey != null) : "tombstoneKey marker must be non null";
  }

  public final/*inline*/ Object getEmptyKey() {
    return emptyKey;
  }

  public final/*inline*/ Object getTombstoneKey() {
    return tombstoneKey;
  }

  /**
   * @return return hashcode for the key (it is neither empty nor tombstone keys)
   */  
  public /*uint*/int getHashValue(/*const*/org.llvm.adt.StringRef Key) {
    assert allowCompareWithEmptyAndTombstone || Key != emptyKey : "Key: must not be called for emptyKey";
    assert allowCompareWithEmptyAndTombstone || Key != tombstoneKey : "Key: must not be called for tombstoneKey";
    assert checkKey(Key);
    return org.llvm.support.llvm.HashString(Key);
  }

  /**
   * IMPORTANT: hashcode value for AltKey must match hash-value for the original key.
   * @return return hashcode for the alternative key types (it is neither empty nor tombstone keys)
   */ 
  public /*uint*/int getHashValueAlt(/*const*/Object/*&*/ AltKey) {
    assert AltKey != emptyKey : "AltKey: must not be called for emptyKey";
    assert AltKey != tombstoneKey : "AltKey: must not be called for tombstoneKey";
    
    throw new UnsupportedOperationException("Override to support alternative Key types with hash same as Key");    
  }

  /**
   * @return true when LHS key is equal to the RHS key (LHS/RHS are neither empty nor tombstone keys)
   */  
  public boolean isEqual(/*const*/org.llvm.adt.StringRef LHS, /*const*/org.llvm.adt.StringRef RHS) {
    assert allowCompareWithEmptyAndTombstone || LHS != emptyKey : "LHS: must not be called for emptyKey";
    assert allowCompareWithEmptyAndTombstone || LHS != tombstoneKey : "LHS: must not be called for tombstoneKey";    
    assert allowCompareWithEmptyAndTombstone || RHS != emptyKey : "RHS: must not be called for emptyKey";
    assert allowCompareWithEmptyAndTombstone || RHS != tombstoneKey : "RHS: must not be called for tombstoneKey";
    assert checkKey(LHS);
    assert checkKey(RHS);
    return org.llvm.support.llvm.$eq_StringRef(LHS, RHS); 
  }

  /**
   * @return true when alternative LHS key is equal to the stored RHS key (LHS/RHS is neither empty nor tombstone keys)
   */  
  public boolean isEqualAlt(/*const*/ Object /*&*/ AltKey, /*const*/ org.llvm.adt.StringRef /*&*/ Key) {
    assert AltKey != emptyKey : "AltKey: must not be called for emptyKey";
    assert AltKey != tombstoneKey : "AltKey: must not be called for tombstoneKey";
    assert allowCompareWithEmptyAndTombstone || Key != emptyKey : "Key: must not be called for emptyKey";
    assert allowCompareWithEmptyAndTombstone || Key != tombstoneKey : "Key: must not be called for tombstoneKey";
    assert checkKey(Key);
    
    throw new UnsupportedOperationException("Override to support alternative Key types comparable with Key");
  }
  
  public boolean isKeyPointerLike() {
    return false;
  }  

  protected boolean checkKey(Object Key) { return checkKeyImpl(Key, false); }
  protected boolean checkAltKey(Object AltKey) { return checkKeyImpl(AltKey, true); }

  protected boolean checkKeyImpl(Object Key, boolean altKey) {
    if (!NativeTrace.isDebugMode()) {
      NativeTrace.printStackTraceOnce(new Exception("must be called inside assert"));
      return true;
    }
    assert Key != null;

    return true;
  }
}
