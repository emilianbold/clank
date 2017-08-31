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

package org.llvm.support.dwarf;

import org.clank.support.*;


//===----------------------------------------------------------------------===//
// Dwarf constants as gleaned from the DWARF Debugging Information Format V.4
// reference manual http://www.dwarfstd.org/.
//

// Do not mix the following two enumerations sets.  DW_TAG_invalid changes the
// enumeration base type.
//<editor-fold defaultstate="collapsed" desc="llvm::dwarf::LLVMConstants">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Dwarf.h", line = 39,
 FQN="llvm::dwarf::LLVMConstants", NM="_ZN4llvm5dwarf13LLVMConstantsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Dwarf.cpp -nm=_ZN4llvm5dwarf13LLVMConstantsE")
//</editor-fold>
public enum LLVMConstants/* : uint32_t*/ implements Native.NativeUIntEnum {
  // LLVM mock tags (see also llvm/Support/Dwarf.def).
  DW_TAG_invalid(~0/*U*/), // Tag for invalid results.
  DW_VIRTUALITY_invalid(~0/*U*/), // Virtuality for invalid results.
  DW_MACINFO_invalid(~0/*U*/), // Macinfo type for invalid results.
  
  // Other constants.
  DWARF_VERSION(4), // Default dwarf version we output.
  DW_PUBTYPES_VERSION(2), // Section version number for .debug_pubtypes.
  DW_PUBNAMES_VERSION(2), // Section version number for .debug_pubnames.
  DW_ARANGES_VERSION(2); // Section version number for .debug_aranges.

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static LLVMConstants valueOf(int val) {
    LLVMConstants out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final LLVMConstants[] VALUES;
    private static final LLVMConstants[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (LLVMConstants kind : LLVMConstants.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new LLVMConstants[min < 0 ? (1-min) : 0];
      VALUES = new LLVMConstants[max >= 0 ? (1+max) : 0];
      for (LLVMConstants kind : LLVMConstants.values()) {
        if (kind.value < 0) {
          if (_VALUES[-kind.value] == null) {
            _VALUES[-kind.value] = kind;
          } else {
            assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        } else {
          if (VALUES[kind.value] == null) {
            VALUES[kind.value] = kind;
          } else {
            assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
          }
        }
      }
    }
  }

  private final /*uint32_t*/int value;
  private LLVMConstants(int val) { this.value = (/*uint32_t*/int)val;}
  @Override public final /*uint32_t*/int getValue() { return value;}
  //</editor-fold>
}