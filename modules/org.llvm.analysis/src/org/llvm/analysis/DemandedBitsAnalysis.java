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

package org.llvm.analysis;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.ir.*;
import org.llvm.ir.java.IPassFunction;


/// An analysis that produces \c DemandedBits for a function.
//<editor-fold defaultstate="collapsed" desc="llvm::DemandedBitsAnalysis">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DemandedBits.h", line = 90,
 FQN="llvm::DemandedBitsAnalysis", NM="_ZN4llvm20DemandedBitsAnalysisE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm20DemandedBitsAnalysisE")
//</editor-fold>
public class DemandedBitsAnalysis implements /*public*/ AnalysisInfoMixin<DemandedBitsAnalysis>, IPassFunction<DemandedBits> {
  /*friend  AnalysisInfoMixin<DemandedBitsAnalysis>*/
  // JAVA: moved to extra/*private*/ static /*char*/byte PassID;
/*public:*/
  /// \brief Provide the result typedef for this analysis pass.
  // JAVA: typedef DemandedBits Result
//  public final class Result extends DemandedBits{ };
  
  /// \brief Run the analysis pass over a function and produce demanded bits
  /// information.
  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBitsAnalysis::run">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp", line = 392,
   FQN="llvm::DemandedBitsAnalysis::run", NM="_ZN4llvm20DemandedBitsAnalysis3runERNS_8FunctionERNS_15AnalysisManagerIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm20DemandedBitsAnalysis3runERNS_8FunctionERNS_15AnalysisManagerIS1_EE")
  //</editor-fold>
  public DemandedBits run(final Function /*&*/ F, 
     final AnalysisManager<Function> /*&*/ AM) {
    final AssumptionCache /*&*/ AC = AM.getResult(AssumptionAnalysis.class, F);
    final DominatorTree /*&*/ DT = AM.getResult(DominatorTreeAnalysis.class, F);
    return new DemandedBits(F, AC, DT);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::DemandedBitsAnalysis::DemandedBitsAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DemandedBits.h", line = 90,
   FQN="llvm::DemandedBitsAnalysis::DemandedBitsAnalysis", NM="_ZN4llvm20DemandedBitsAnalysisC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm20DemandedBitsAnalysisC1EOS0_")
  //</editor-fold>
  public /*inline*/ DemandedBitsAnalysis(JD$Move _dparam, final DemandedBitsAnalysis /*&&*/$Prm0) {
    // : AnalysisInfoMixin<DemandedBitsAnalysis>(static_cast<DemandedBitsAnalysis &&>()) 
    //START JInit
    $AnalysisInfoMixin(JD$Move.INSTANCE, $Prm0);
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static Class<DemandedBitsAnalysis> PassID = DemandedBitsAnalysis.class;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
