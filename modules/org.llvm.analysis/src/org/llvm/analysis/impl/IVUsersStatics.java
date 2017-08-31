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
package org.llvm.analysis.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;


//<editor-fold defaultstate="collapsed" desc="static type IVUsersStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.IVUsersStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZL13isInterestingPKN4llvm4SCEVEPKNS_11InstructionEPKNS_4LoopEPNS_15ScalarEvolutionEPNS_8LoopInfoE;_ZL17findAddRecForLoopPKN4llvm4SCEVEPKNS_4LoopE;_ZL20isSimplifiedLoopNestPN4llvm10BasicBlockEPKNS_13DominatorTreeEPKNS_8LoopInfoERNS_15SmallPtrSetImplIPNS_4LoopEEE;_ZL36InitializeIVUsersWrapperPassPassFlag;_ZL36initializeIVUsersWrapperPassPassOnceRN4llvm12PassRegistryE; -static-type=IVUsersStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class IVUsersStatics {

//<editor-fold defaultstate="collapsed" desc="initializeIVUsersWrapperPassPassOnce">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp", line = 56,
 FQN="initializeIVUsersWrapperPassPassOnce", NM="_ZL36initializeIVUsersWrapperPassPassOnceRN4llvm12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZL36initializeIVUsersWrapperPassPassOnceRN4llvm12PassRegistryE")
//</editor-fold>
public static Object/*void P*/ initializeIVUsersWrapperPassPassOnce(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="InitializeIVUsersWrapperPassPassFlag">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp", line = 62,
 FQN="InitializeIVUsersWrapperPassPassFlag", NM="_ZL36InitializeIVUsersWrapperPassPassFlag",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZL36InitializeIVUsersWrapperPassPassFlag")
//</editor-fold>
public static std.once_flag InitializeIVUsersWrapperPassPassFlag/*J*/= new std.once_flag();

/// isInteresting - Test whether the given expression is "interesting" when
/// used by the given expression, within the context of analyzing the
/// given loop.
//<editor-fold defaultstate="collapsed" desc="isInteresting">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp", line = 70,
 FQN="isInteresting", NM="_ZL13isInterestingPKN4llvm4SCEVEPKNS_11InstructionEPKNS_4LoopEPNS_15ScalarEvolutionEPNS_8LoopInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZL13isInterestingPKN4llvm4SCEVEPKNS_11InstructionEPKNS_4LoopEPNS_15ScalarEvolutionEPNS_8LoopInfoE")
//</editor-fold>
public static boolean isInteresting(/*const*/ SCEV /*P*/ S, /*const*/ Instruction /*P*/ I, /*const*/ Loop /*P*/ L, 
             ScalarEvolution /*P*/ SE, LoopInfo /*P*/ LI) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if all loop headers that dominate this block are in simplified
/// form.
//<editor-fold defaultstate="collapsed" desc="isSimplifiedLoopNest">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp", line = 106,
 FQN="isSimplifiedLoopNest", NM="_ZL20isSimplifiedLoopNestPN4llvm10BasicBlockEPKNS_13DominatorTreeEPKNS_8LoopInfoERNS_15SmallPtrSetImplIPNS_4LoopEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZL20isSimplifiedLoopNestPN4llvm10BasicBlockEPKNS_13DominatorTreeEPKNS_8LoopInfoERNS_15SmallPtrSetImplIPNS_4LoopEEE")
//</editor-fold>
public static boolean isSimplifiedLoopNest(BasicBlock /*P*/ BB, /*const*/ DominatorTree /*P*/ DT, 
                    /*const*/ LoopInfo /*P*/ LI, 
                    final SmallPtrSetImpl<Loop /*P*/ > /*&*/ SimpleLoopNests) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="findAddRecForLoop">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp", line = 359,
 FQN="findAddRecForLoop", NM="_ZL17findAddRecForLoopPKN4llvm4SCEVEPKNS_4LoopE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZL17findAddRecForLoopPKN4llvm4SCEVEPKNS_4LoopE")
//</editor-fold>
public static /*const*/ SCEVAddRecExpr /*P*/ findAddRecForLoop(/*const*/ SCEV /*P*/ S, /*const*/ Loop /*P*/ L) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class IVUsersStatics