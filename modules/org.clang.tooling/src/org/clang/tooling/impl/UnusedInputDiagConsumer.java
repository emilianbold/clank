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

package org.clang.tooling.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;


// Special DiagnosticConsumer that looks for warn_drv_input_file_unused
// diagnostics from the driver and collects the option strings for those unused
// options.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnusedInputDiagConsumer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp", line = 150,
 FQN="(anonymous namespace)::UnusedInputDiagConsumer", NM="_ZN12_GLOBAL__N_123UnusedInputDiagConsumerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZN12_GLOBAL__N_123UnusedInputDiagConsumerE")
//</editor-fold>
public class UnusedInputDiagConsumer extends /*public*/ DiagnosticConsumer implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnusedInputDiagConsumer::UnusedInputDiagConsumer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp", line = 152,
   FQN="(anonymous namespace)::UnusedInputDiagConsumer::UnusedInputDiagConsumer", NM="_ZN12_GLOBAL__N_123UnusedInputDiagConsumerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZN12_GLOBAL__N_123UnusedInputDiagConsumerC1Ev")
  //</editor-fold>
  public UnusedInputDiagConsumer() {
    // : DiagnosticConsumer(), Other(null), UnusedInputs() 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // Useful for debugging, chain diagnostics to another consumer after
  // recording for our own purposes.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnusedInputDiagConsumer::UnusedInputDiagConsumer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp", line = 156,
   FQN="(anonymous namespace)::UnusedInputDiagConsumer::UnusedInputDiagConsumer", NM="_ZN12_GLOBAL__N_123UnusedInputDiagConsumerC1EPN5clang18DiagnosticConsumerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZN12_GLOBAL__N_123UnusedInputDiagConsumerC1EPN5clang18DiagnosticConsumerE")
  //</editor-fold>
  public UnusedInputDiagConsumer(DiagnosticConsumer /*P*/ Other) {
    // : DiagnosticConsumer(), Other(Other), UnusedInputs() 
    super();
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnusedInputDiagConsumer::HandleDiagnostic">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp", line = 158,
   FQN="(anonymous namespace)::UnusedInputDiagConsumer::HandleDiagnostic", NM="_ZN12_GLOBAL__N_123UnusedInputDiagConsumer16HandleDiagnosticEN5clang17DiagnosticsEngine5LevelERKNS1_10DiagnosticE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZN12_GLOBAL__N_123UnusedInputDiagConsumer16HandleDiagnosticEN5clang17DiagnosticsEngine5LevelERKNS1_10DiagnosticE")
  //</editor-fold>
  @Override public void HandleDiagnostic(DiagnosticsEngine.Level DiagLevel, 
                  final /*const*/ Diagnostic /*&*/ Info)/* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  public DiagnosticConsumer /*P*/ Other;
  public SmallVector<std.string> UnusedInputs;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnusedInputDiagConsumer::~UnusedInputDiagConsumer">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp", line = 150,
   FQN="(anonymous namespace)::UnusedInputDiagConsumer::~UnusedInputDiagConsumer", NM="_ZN12_GLOBAL__N_123UnusedInputDiagConsumerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/CompilationDatabase.cpp -nm=_ZN12_GLOBAL__N_123UnusedInputDiagConsumerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Other=" + "[DiagnosticConsumer]" // NOI18N
              + ", UnusedInputs=" + UnusedInputs // NOI18N
              + super.toString(); // NOI18N
  }
}