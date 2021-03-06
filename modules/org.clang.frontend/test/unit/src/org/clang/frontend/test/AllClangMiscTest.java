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
package org.clang.frontend.test;

import org.clang.tools.driver.test.DriverTestFileBase;
import org.junit.*;

// 
/**
 * Collection of all test files from test/Misc folder
 * @author Vladimir Voskresensky
 */
public class AllClangMiscTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/Misc/";
  public AllClangMiscTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, 
            TEST_LOCATION, (test)->{ return true;/*test.getFileIndexInFolder()<120;*/ }, 
            "${SPUTNIK}/modules/org.clang.frontend/test/unit/src/org/clang/frontend/AllClangMiscTest.txt");
  }  

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_amdgcn_languageOptsOpenCL_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/amdgcn.languageOptsOpenCL.cl");
    // REQUIRES: amdgpu-registered-target
    if (!CHECK_REQUIRES("amdgpu-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL ${LLVM_SRC}/llvm/tools/clang/test/Misc/amdgcn.languageOptsOpenCL.cl -verify -triple amdgcn-unknown-unknown
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL %s -verify -triple amdgcn-unknown-unknown");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.1 ${LLVM_SRC}/llvm/tools/clang/test/Misc/amdgcn.languageOptsOpenCL.cl -verify -triple amdgcn-unknown-unknown
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.1 %s -verify -triple amdgcn-unknown-unknown");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.2 ${LLVM_SRC}/llvm/tools/clang/test/Misc/amdgcn.languageOptsOpenCL.cl -verify -triple amdgcn-unknown-unknown
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.2 %s -verify -triple amdgcn-unknown-unknown");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL2.0 ${LLVM_SRC}/llvm/tools/clang/test/Misc/amdgcn.languageOptsOpenCL.cl -verify -triple amdgcn-unknown-unknown
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL2.0 %s -verify -triple amdgcn-unknown-unknown");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL ${LLVM_SRC}/llvm/tools/clang/test/Misc/amdgcn.languageOptsOpenCL.cl -verify -triple amdgcn-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL %s -verify -triple amdgcn-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.1 ${LLVM_SRC}/llvm/tools/clang/test/Misc/amdgcn.languageOptsOpenCL.cl -verify -triple amdgcn-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.1 %s -verify -triple amdgcn-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.2 ${LLVM_SRC}/llvm/tools/clang/test/Misc/amdgcn.languageOptsOpenCL.cl -verify -triple amdgcn-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.2 %s -verify -triple amdgcn-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL2.0 ${LLVM_SRC}/llvm/tools/clang/test/Misc/amdgcn.languageOptsOpenCL.cl -verify -triple amdgcn-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL2.0 %s -verify -triple amdgcn-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES");
  }

  @Test
  public void test_ast_dump_arm_attr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-arm-attr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-apple-darwin -ast-dump -ast-dump-filter Test ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-arm-attr.c | ${LLVM_SRC}/build/bin/FileCheck --strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-arm-attr.c
    RUN("%clang_cc1 -triple arm-apple-darwin -ast-dump -ast-dump-filter Test %s")./*|*/
      I("FileCheck --strict-whitespace %s");
  }

  @Test
  public void test_ast_dump_attr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-attr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux -std=c++11 -Wno-deprecated-declarations -ast-dump -ast-dump-filter Test ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-attr.cpp | ${LLVM_SRC}/build/bin/FileCheck --strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-attr.cpp
    RUN("%clang_cc1 -triple x86_64-pc-linux -std=c++11 -Wno-deprecated-declarations -ast-dump -ast-dump-filter Test %s")./*|*/
      I("FileCheck --strict-whitespace %s");
  }

  @Test
  public void test_ast_dump_color_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-color.cpp");
    // REQUIRES: ansi-escape-sequences
    if (!CHECK_REQUIRES("ansi-escape-sequences")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-pc-linux -std=c++11 -ast-dump -fcolor-diagnostics ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-color.cpp | ${LLVM_SRC}/build/bin/FileCheck --strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-color.cpp
    RUN("not %clang_cc1 -triple x86_64-pc-linux -std=c++11 -ast-dump -fcolor-diagnostics %s")./*|*/
      I("FileCheck --strict-whitespace %s");
  }

  @Test
  public void test_ast_dump_comment_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-comment.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wdocumentation -ast-dump -ast-dump-filter Test ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-comment.cpp | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-comment.cpp
    RUN("%clang_cc1 -Wdocumentation -ast-dump -ast-dump-filter Test %s")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_ast_dump_decl_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-decl.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -ast-dump -ast-dump-filter Test ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-decl.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-decl.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -ast-dump -ast-dump-filter Test %s")./*|*/
      I("FileCheck -check-prefix CHECK -strict-whitespace %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-decl.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-TU -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-decl.c
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -ast-dump %s")./*|*/
      I("FileCheck -check-prefix CHECK-TU -strict-whitespace %s");
  }

  @Test
  public void test_ast_dump_decl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-decl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-linux-gnu -fms-extensions -ast-dump -ast-dump-filter Test ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-decl.cpp | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-decl.cpp
    RUN("%clang_cc1 -std=c++11 -triple x86_64-linux-gnu -fms-extensions -ast-dump -ast-dump-filter Test %s")./*|*/
      I("FileCheck -check-prefix CHECK -strict-whitespace %s");
  }

  @Test
  public void test_ast_dump_decl_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-decl.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-unused -fblocks -ast-dump -ast-dump-filter Test ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-decl.m | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-decl.m
    RUN(TestState.Failed, "%clang_cc1 -Wno-unused -fblocks -ast-dump -ast-dump-filter Test %s")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_ast_dump_decl_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-decl.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-unused -fblocks -ast-dump -ast-dump-filter Test ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-decl.mm | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-decl.mm
    RUN("%clang_cc1 -Wno-unused -fblocks -ast-dump -ast-dump-filter Test %s")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_ast_dump_invalid_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-invalid.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -triple x86_64-linux-gnu -fms-extensions -ast-dump -ast-dump-filter Test ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-invalid.cpp | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-invalid.cpp
    RUN("not %clang_cc1 -std=c++11 -triple x86_64-linux-gnu -fms-extensions -ast-dump -ast-dump-filter Test %s")./*|*/
      I("FileCheck -check-prefix CHECK -strict-whitespace %s");
  }

  @Test
  public void test_ast_dump_lookups_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-lookups.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -ast-dump -ast-dump-filter Test ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-lookups.cpp | ${LLVM_SRC}/build/bin/FileCheck -check-prefix DECLS ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-lookups.cpp
    RUN("%clang_cc1 -std=c++11 -ast-dump -ast-dump-filter Test %s")./*|*/
      I("FileCheck -check-prefix DECLS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -ast-dump-lookups -ast-dump-filter Test ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-lookups.cpp | ${LLVM_SRC}/build/bin/FileCheck -check-prefix LOOKUPS ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-lookups.cpp
    RUN("%clang_cc1 -std=c++11 -ast-dump-lookups -ast-dump-filter Test %s")./*|*/
      I("FileCheck -check-prefix LOOKUPS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -ast-dump -ast-dump-lookups -ast-dump-filter Test ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-lookups.cpp | ${LLVM_SRC}/build/bin/FileCheck -check-prefix DECLS-LOOKUPS ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-lookups.cpp
    RUN("%clang_cc1 -std=c++11 -ast-dump -ast-dump-lookups -ast-dump-filter Test %s")./*|*/
      I("FileCheck -check-prefix DECLS-LOOKUPS %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -DPRAGMA -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-lookups.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix PRAGMA ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-lookups.cpp
    RUN("%clang_cc1 -std=c++11 -DPRAGMA -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck -check-prefix PRAGMA %s");
  }

  @Test
  public void test_ast_dump_msp430_attr_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-msp430-attr.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple msp430-unknown-unknown -ast-dump -ast-dump-filter Test ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-msp430-attr.c | ${LLVM_SRC}/build/bin/FileCheck --strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-msp430-attr.c
    RUN("%clang_cc1 -triple msp430-unknown-unknown -ast-dump -ast-dump-filter Test %s")./*|*/
      I("FileCheck --strict-whitespace %s");
  }

  @Test
  public void test_ast_dump_pipe_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-pipe.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple spir64 -cl-std=CL2.0 -ast-dump -ast-dump-filter pipetype ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-pipe.cl | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-pipe.cl
    RUN("%clang_cc1 -triple spir64 -cl-std=CL2.0 -ast-dump -ast-dump-filter pipetype %s")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_ast_dump_stmt_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-stmt.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-dump -ast-dump-filter Test ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-stmt.c | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-stmt.c
    RUN("%clang_cc1 -ast-dump -ast-dump-filter Test %s")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_ast_dump_stmt_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-stmt.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -ast-dump -ast-dump-filter Test ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-stmt.cpp | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-stmt.cpp
    RUN("%clang_cc1 -fcxx-exceptions -ast-dump -ast-dump-filter Test %s")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_ast_dump_stmt_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-stmt.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wno-unused -fblocks -fobjc-exceptions -ast-dump -ast-dump-filter Test ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-stmt.m | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-stmt.m
    RUN("%clang_cc1 -Wno-unused -fblocks -fobjc-exceptions -ast-dump -ast-dump-filter Test %s")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_ast_dump_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-templates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-print ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-templates.cpp > ${TEST_TEMP_DIR}/ast-dump-templates.cpp.tmp
    RUN("%clang_cc1 -ast-print %s > %t");
    // ${LLVM_SRC}/build/bin/FileCheck < ${TEST_TEMP_DIR}/ast-dump-templates.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-templates.cpp -check-prefix=CHECK1
    RUN("FileCheck < %t %s -check-prefix=CHECK1");
    // ${LLVM_SRC}/build/bin/FileCheck < ${TEST_TEMP_DIR}/ast-dump-templates.cpp.tmp ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-templates.cpp -check-prefix=CHECK2
    RUN("FileCheck < %t %s -check-prefix=CHECK2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-templates.cpp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=DUMP ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-templates.cpp
    RUN("%clang_cc1 -ast-dump %s")./*|*/
      I("FileCheck --check-prefix=DUMP %s");
  }

  @Test
  public void test_ast_dump_wchar_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-wchar.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-wchar.cpp -triple x86_64-linux-gnu | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-dump-wchar.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -ast-dump %s -triple x86_64-linux-gnu")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ast_print_char_literal_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-print-char-literal.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-print -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-print-char-literal.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-print-char-literal.cpp
    RUN("%clang_cc1 -ast-print -std=c++1z %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ast_print_objectivec_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-print-objectivec.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-print ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-print-objectivec.m -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-print-objectivec.m
    RUN("%clang_cc1 -ast-print %s -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_ast_print_pragmas_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-print-pragmas.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-print ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-print-pragmas.cpp -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-print-pragmas.cpp
    RUN("%clang_cc1 -ast-print %s -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -DMS_EXT -fsyntax-only -fms-extensions ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-print-pragmas.cpp -triple x86_64-pc-win32 -ast-print | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-print-pragmas.cpp --check-prefix=MS-EXT
    RUN("%clang_cc1 -DMS_EXT -fsyntax-only -fms-extensions %s -triple x86_64-pc-win32 -ast-print")./*|*/
      I("FileCheck %s --check-prefix=MS-EXT");
  }

  @Test
  public void test_ast_print_pragmas_xfail_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-print-pragmas-xfail.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-print-pragmas-xfail.cpp -ast-print -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/ast-print-pragmas-xfail.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -ast-print -o -")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_attr_source_range_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/attr-source-range.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-print-source-range-info ${LLVM_SRC}/llvm/tools/clang/test/Misc/attr-source-range.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/attr-source-range.cpp
    RUN("not %clang_cc1 -fsyntax-only -fdiagnostics-print-source-range-info %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_backend_optimization_failure_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/backend-optimization-failure.cpp");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/Misc/backend-optimization-failure.cpp -O3 -emit-llvm -debug-info-kind=line-tables-only -S -verify -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown %s -O3 -emit-llvm -debug-info-kind=line-tables-only -S -verify -o /dev/null");
  }

  @Test
  public void test_backend_optimization_failure_nodbg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/backend-optimization-failure-nodbg.cpp");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown ${LLVM_SRC}/llvm/tools/clang/test/Misc/backend-optimization-failure-nodbg.cpp -O3 -emit-llvm -S -verify -o /dev/null
    RUN(TestState.Failed, "%clang_cc1 -triple x86_64-unknown-unknown %s -O3 -emit-llvm -S -verify -o /dev/null");
  }

  @Test
  public void test_backend_resource_limit_diagnostics_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/backend-resource-limit-diagnostics.cl");
    // REQUIRES: amdgpu-registered-target
    if (!CHECK_REQUIRES("amdgpu-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-codegen-only -triple=amdgcn-- ${LLVM_SRC}/llvm/tools/clang/test/Misc/backend-resource-limit-diagnostics.cl 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/backend-resource-limit-diagnostics.cl
    RUN(TestState.Failed, "not %clang_cc1 -emit-codegen-only -triple=amdgcn-- %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_backend_stack_frame_diagnostics_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/backend-stack-frame-diagnostics.cpp");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -target i386-apple-darwin -std=c++11 -fblocks -Wframe-larger-than=70 -Xclang -verify -o /dev/null -c ${LLVM_SRC}/llvm/tools/clang/test/Misc/backend-stack-frame-diagnostics.cpp
    RUN(TestState.Failed, "%clang -target i386-apple-darwin -std=c++11 -fblocks -Wframe-larger-than=70 -Xclang -verify -o /dev/null -c %s");
    // ${LLVM_SRC}/build/bin/clang -target i386-apple-darwin -std=c++11 -fblocks -Wframe-larger-than=70 -Xclang -verify -o /dev/null -c ${LLVM_SRC}/llvm/tools/clang/test/Misc/backend-stack-frame-diagnostics.cpp -DIS_SYSHEADER
    RUN(TestState.Failed, "%clang -target i386-apple-darwin -std=c++11 -fblocks -Wframe-larger-than=70 -Xclang -verify -o /dev/null -c %s -DIS_SYSHEADER");
    // touch ${TEST_TEMP_DIR}/backend-stack-frame-diagnostics.cpp.tmp.o
    RUN(TestState.Failed, "touch %t.o");
    // ${LLVM_SRC}/build/bin/clang -Werror -Wframe-larger-than=0 ${TEST_TEMP_DIR}/backend-stack-frame-diagnostics.cpp.tmp.o -### 2>&1 | not grep ' error: '
    RUN(TestState.Failed, "%clang -Werror -Wframe-larger-than=0 %t.o -###  2>&1")./*|*/
      I("not grep ' error: '");
  }

  @Test
  public void test_backend_stack_frame_diagnostics_fallback_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/backend-stack-frame-diagnostics-fallback.cpp");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/backend-stack-frame-diagnostics-fallback.cpp -mllvm -warn-stack-size=0 -emit-codegen-only -triple=i386-apple-darwin 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/backend-stack-frame-diagnostics-fallback.cpp
    RUN(TestState.SemanticErrors/*WarnStackSize from llvm/CodeGen is not generated*/, "%clang_cc1 %s -mllvm -warn-stack-size=0 -emit-codegen-only -triple=i386-apple-darwin 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_caret_diags_macros_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/caret-diags-macros.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/caret-diags-macros.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/caret-diags-macros.c -strict-whitespace
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s -strict-whitespace");
  }

  @Test
  public void test_caret_diags_scratch_buffer_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/caret-diags-scratch-buffer.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/caret-diags-scratch-buffer.c 2>&1 | not grep keyXXXX
    RUN("not %clang_cc1 -fsyntax-only %s 2>&1")./*|*/
      I("not grep keyXXXX");
  }

  @Test
  public void test_cc1as_asm_s() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/cc1as-asm.s");
    // REQUIRES: x86-registered-target
    if (!CHECK_REQUIRES("x86-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1as -triple x86_64-apple-macosx10.10.0 -filetype asm ${LLVM_SRC}/llvm/tools/clang/test/Misc/cc1as-asm.s -o /dev/null
    RUN(TestState.Failed, "%clang -cc1as -triple x86_64-apple-macosx10.10.0 -filetype asm %s -o /dev/null");
  }

  @Test
  public void test_dev_fd_fs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/dev-fd-fs.c");
    // REQUIRES: dev-fd-fs
    if (!CHECK_REQUIRES("dev-fd-fs")) {
      return;
    }
    // cat ${LLVM_SRC}/llvm/tools/clang/test/Misc/dev-fd-fs.c | ${LLVM_SRC}/build/bin/clang -x c /dev/fd/0 -E > ${TEST_TEMP_DIR}/dev-fd-fs.c.tmp
    RUN(TestState.Failed, "cat %s")./*|*/
      I("%clang -x c /dev/fd/0 -E > %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix DEV-FD-INPUT < ${TEST_TEMP_DIR}/dev-fd-fs.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Misc/dev-fd-fs.c
    RUN(TestState.Failed, "FileCheck --check-prefix DEV-FD-INPUT < %t %s");
    // ${LLVM_SRC}/build/bin/clang -x c ${LLVM_SRC}/llvm/tools/clang/test/Misc/dev-fd-fs.c -E -o /dev/fd/1 | cat > ${TEST_TEMP_DIR}/dev-fd-fs.c.tmp
    RUN(TestState.Failed, "%clang -x c %s -E -o /dev/fd/1")./*|*/
      I("cat > %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix DEV-FD-FIFO-OUTPUT < ${TEST_TEMP_DIR}/dev-fd-fs.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Misc/dev-fd-fs.c
    RUN(TestState.Failed, "FileCheck --check-prefix DEV-FD-FIFO-OUTPUT < %t %s");
    // ${LLVM_SRC}/build/bin/clang -x c ${LLVM_SRC}/llvm/tools/clang/test/Misc/dev-fd-fs.c -E -o /dev/fd/1 > ${TEST_TEMP_DIR}/dev-fd-fs.c.tmp
    RUN(TestState.Failed, "%clang -x c %s -E -o /dev/fd/1 > %t");
    // ${LLVM_SRC}/build/bin/FileCheck --check-prefix DEV-FD-REG-OUTPUT < ${TEST_TEMP_DIR}/dev-fd-fs.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Misc/dev-fd-fs.c
    RUN(TestState.Failed, "FileCheck --check-prefix DEV-FD-REG-OUTPUT < %t %s");
  }

  @Test
  public void test_diag_aka_types_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-aka-types.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-aka-types.cpp -fsyntax-only -verify -std=c++11
    RUN("%clang_cc1 %s -fsyntax-only -verify -std=c++11");
  }

  @Test
  public void test_diag_format_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c -check-prefix=DEFAULT
    RUN("%clang -fsyntax-only  %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=DEFAULT");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -fdiagnostics-format=clang ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c -check-prefix=DEFAULT
    RUN("%clang -fsyntax-only -fdiagnostics-format=clang %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=DEFAULT");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -fdiagnostics-format=clang -target x86_64-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c -check-prefix=DEFAULT
    RUN("%clang -fsyntax-only -fdiagnostics-format=clang -target x86_64-pc-win32 %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=DEFAULT");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -fdiagnostics-format=msvc -fmsc-version=1300 ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c -check-prefix=MSVC2010
    RUN("%clang -fsyntax-only -fdiagnostics-format=msvc -fmsc-version=1300  %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=MSVC2010");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -fdiagnostics-format=msvc -fms-compatibility-version=13.00 ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c -check-prefix=MSVC2010
    RUN("%clang -fsyntax-only -fdiagnostics-format=msvc -fms-compatibility-version=13.00  %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=MSVC2010");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -fdiagnostics-format=msvc -fmsc-version=1300 -target x86_64-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c -check-prefix=MSVC2010
    RUN("%clang -fsyntax-only -fdiagnostics-format=msvc -fmsc-version=1300 -target x86_64-pc-win32 %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=MSVC2010");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -fdiagnostics-format=msvc -fms-compatibility-version=13.00 -target x86_64-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c -check-prefix=MSVC2010
    RUN("%clang -fsyntax-only -fdiagnostics-format=msvc -fms-compatibility-version=13.00 -target x86_64-pc-win32 %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=MSVC2010");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -fdiagnostics-format=msvc -fmsc-version=1300 -target x86_64-pc-win32 -fshow-column ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c -check-prefix=MSVC2010
    RUN("%clang -fsyntax-only -fdiagnostics-format=msvc -fmsc-version=1300 -target x86_64-pc-win32 -fshow-column %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=MSVC2010");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -fdiagnostics-format=msvc -fmsc-version=1800 -target x86_64-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c -check-prefix=MSVC2013
    RUN("%clang -fsyntax-only -fdiagnostics-format=msvc -fmsc-version=1800 -target x86_64-pc-win32 %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=MSVC2013");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -fdiagnostics-format=msvc -target x86_64-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c -check-prefix=MSVC
    RUN("%clang -fsyntax-only -fdiagnostics-format=msvc -target x86_64-pc-win32 %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=MSVC");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -fdiagnostics-format=msvc -fmsc-version=1900 -target x86_64-pc-win32 ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c -check-prefix=MSVC2015
    RUN("%clang -fsyntax-only -fdiagnostics-format=msvc -fmsc-version=1900 -target x86_64-pc-win32 %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=MSVC2015");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -fdiagnostics-format=msvc -fms-compatibility-version=13.00 -target x86_64-pc-win32 -fshow-column ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c -check-prefix=MSVC2010
    RUN("%clang -fsyntax-only -fdiagnostics-format=msvc -fms-compatibility-version=13.00 -target x86_64-pc-win32 -fshow-column %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=MSVC2010");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -fdiagnostics-format=msvc -fmsc-version=1800 -target x86_64-pc-win32 -fshow-column ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c -check-prefix=MSVC2013
    RUN("%clang -fsyntax-only -fdiagnostics-format=msvc -fmsc-version=1800 -target x86_64-pc-win32 -fshow-column %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=MSVC2013");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -fdiagnostics-format=msvc -target x86_64-pc-win32 -fshow-column ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c -check-prefix=MSVC
    RUN("%clang -fsyntax-only -fdiagnostics-format=msvc -target x86_64-pc-win32 -fshow-column %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=MSVC");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -fdiagnostics-format=msvc -fmsc-version=1900 -target x86_64-pc-win32 -fshow-column ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c -check-prefix=MSVC2015
    RUN("%clang -fsyntax-only -fdiagnostics-format=msvc -fmsc-version=1900 -target x86_64-pc-win32 -fshow-column %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=MSVC2015");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -fdiagnostics-format=vi ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c -check-prefix=VI
    RUN("%clang -fsyntax-only -fdiagnostics-format=vi    %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=VI");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -fdiagnostics-format=msvc -fno-show-column -fmsc-version=1900 ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c -check-prefix=MSVC2015_ORIG
    RUN("%clang -fsyntax-only -fdiagnostics-format=msvc -fno-show-column -fmsc-version=1900 %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=MSVC2015_ORIG");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -fno-show-column ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c -check-prefix=NO_COLUMN
    RUN("%clang -fsyntax-only -fno-show-column %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=NO_COLUMN");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -Werror -fdiagnostics-format=msvc-fallback -fmsc-version=1300 ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c -check-prefix=MSVC2010-FALLBACK
    RUN("not %clang -fsyntax-only -Werror -fdiagnostics-format=msvc-fallback -fmsc-version=1300 %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=MSVC2010-FALLBACK");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -Werror -fdiagnostics-format=msvc-fallback -fms-compatibility-version=13.00 ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c -check-prefix=MSVC2010-FALLBACK
    RUN("not %clang -fsyntax-only -Werror -fdiagnostics-format=msvc-fallback -fms-compatibility-version=13.00 %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=MSVC2010-FALLBACK");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -Werror -fdiagnostics-format=msvc-fallback -fmsc-version=1800 ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c -check-prefix=MSVC2013-FALLBACK
    RUN("not %clang -fsyntax-only -Werror -fdiagnostics-format=msvc-fallback -fmsc-version=1800 %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=MSVC2013-FALLBACK");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -Werror -fdiagnostics-format=msvc-fallback -fmsc-version=1900 ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-format.c -check-prefix=MSVC2015-FALLBACK
    RUN("not %clang -fsyntax-only -Werror -fdiagnostics-format=msvc-fallback -fmsc-version=1900 %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=MSVC2015-FALLBACK");
  }

  @Test
  public void test_diag_line_wrapping_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-line-wrapping.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fmessage-length 60 ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-line-wrapping.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-line-wrapping.cpp
    RUN("not %clang_cc1 -fsyntax-only -fmessage-length 60 %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fmessage-length 0 ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-line-wrapping.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-line-wrapping.cpp
    RUN("not %clang_cc1 -fsyntax-only -fmessage-length 0 %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_diag_macro_backtrace_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-macro-backtrace.c");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -fmacro-backtrace-limit=0 ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-macro-backtrace.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-macro-backtrace.c
    RUN("not %clang -fsyntax-only -fmacro-backtrace-limit=0 %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_diag_macro_backtrace2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-macro-backtrace2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-macro-backtrace2.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-macro-backtrace2.c
    RUN("not %clang -cc1 -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_diag_mapping_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-mapping.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-mapping.c 2>&1 | grep warning:
    RUN("%clang_cc1 %s 2>&1")./*|*/
      I("grep \"warning:\"");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-mapping.c -Wno-extra-tokens 2>&1 | not grep diagnostic
    RUN("%clang_cc1 %s -Wno-extra-tokens 2>&1")./*|*/
      I("not grep diagnostic");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-mapping.c -Werror 2>&1 | grep error:
    RUN("not %clang_cc1 %s -Werror 2>&1")./*|*/
      I("grep \"error:\"");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-mapping.c -Werror=extra-tokens 2>&1 | grep error:
    RUN("not %clang_cc1 %s -Werror=extra-tokens 2>&1")./*|*/
      I("grep \"error:\"");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-mapping.c -Werror=trigraphs 2>&1 | grep warning:
    RUN("%clang_cc1 %s -Werror=trigraphs 2>&1")./*|*/
      I("grep \"warning:\"");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-mapping.c -pedantic 2>&1 | grep warning:
    RUN("%clang_cc1 %s -pedantic 2>&1")./*|*/
      I("grep \"warning:\"");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-mapping.c -pedantic-errors 2>&1 | grep error:
    RUN("not %clang_cc1 %s -pedantic-errors 2>&1")./*|*/
      I("grep \"error:\"");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-mapping.c -pedantic-errors -Wextra-tokens 2>&1 | grep warning:
    RUN("%clang_cc1 %s -pedantic-errors -Wextra-tokens 2>&1")./*|*/
      I("grep \"warning:\"");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-mapping.c -pedantic-errors -Wno-extra-tokens 2>&1 | not grep diagnostic
    RUN("%clang_cc1 %s -pedantic-errors -Wno-extra-tokens 2>&1")./*|*/
      I("not grep diagnostic");
  }

  @Test
  public void test_diag_mapping2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-mapping2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-mapping2.c 2>&1 | grep 'warning: foo'
    RUN("%clang_cc1 %s 2>&1")./*|*/
      I("grep \"warning: foo\"");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-mapping2.c -w 2>&1 | not grep diagnostic
    RUN("%clang_cc1 %s -w 2>&1")./*|*/
      I("not grep diagnostic");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-mapping2.c -Wno-#warnings 2>&1 | not grep diagnostic
    RUN("%clang_cc1 %s -Wno-#warnings 2>&1")./*|*/
      I("not grep diagnostic");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-mapping2.c -Werror 2>&1 | grep 'error: foo'
    RUN("not %clang_cc1 %s -Werror 2>&1")./*|*/
      I("grep \"error: foo\"");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-mapping2.c -Werror=#warnings 2>&1 | grep 'error: foo'
    RUN("not %clang_cc1 %s -Werror=#warnings 2>&1")./*|*/
      I("grep \"error: foo\"");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-mapping2.c -Werror -Wno-error=#warnings 2>&1 | grep 'warning: foo'
    RUN("%clang_cc1 %s -Werror -Wno-error=#warnings 2>&1")./*|*/
      I("grep \"warning: foo\"");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-mapping2.c -Werror -Wno-error 2>&1 | grep 'warning: foo'
    RUN("%clang_cc1 %s -Werror -Wno-error 2>&1")./*|*/
      I("grep \"warning: foo\"");
  }

  @Test
  public void test_diag_null_bytes_in_line_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-null-bytes-in-line.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-null-bytes-in-line.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-null-bytes-in-line.cpp
    RUN("not %clang_cc1 -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_diag_presumed_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-presumed.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic-errors ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-presumed.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-presumed.c --check-prefix=PRESUMED
    RUN("not %clang_cc1 -fsyntax-only -pedantic-errors %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix=PRESUMED");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic-errors -fno-diagnostics-use-presumed-location ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-presumed.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-presumed.c --check-prefix=SPELLING
    RUN("not %clang_cc1 -fsyntax-only -pedantic-errors -fno-diagnostics-use-presumed-location %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix=SPELLING");
  }

  @Test
  public void test_diag_special_chars_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-special-chars.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-special-chars.c -verify
    RUN("%clang_cc1 %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-special-chars.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-special-chars.c
    RUN("not %clang_cc1 %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_diag_template_diffing_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-template-diffing.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-template-diffing.cpp -std=c++11 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-template-diffing.cpp -check-prefix=CHECK-ELIDE-NOTREE
    RUN("not %clang_cc1 -fsyntax-only %s -std=c++11 2>&1")./*|*/
      I("FileCheck %s -check-prefix=CHECK-ELIDE-NOTREE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-template-diffing.cpp -fno-elide-type -std=c++11 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-template-diffing.cpp -check-prefix=CHECK-NOELIDE-NOTREE
    RUN("not %clang_cc1 -fsyntax-only %s -fno-elide-type -std=c++11 2>&1")./*|*/
      I("FileCheck %s -check-prefix=CHECK-NOELIDE-NOTREE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-template-diffing.cpp -fdiagnostics-show-template-tree -std=c++11 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-template-diffing.cpp -check-prefix=CHECK-ELIDE-TREE
    RUN("not %clang_cc1 -fsyntax-only %s -fdiagnostics-show-template-tree -std=c++11 2>&1")./*|*/
      I("FileCheck %s -check-prefix=CHECK-ELIDE-TREE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-template-diffing.cpp -fno-elide-type -fdiagnostics-show-template-tree -std=c++11 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-template-diffing.cpp -check-prefix=CHECK-NOELIDE-TREE
    RUN("not %clang_cc1 -fsyntax-only %s -fno-elide-type -fdiagnostics-show-template-tree -std=c++11 2>&1")./*|*/
      I("FileCheck %s -check-prefix=CHECK-NOELIDE-TREE");
  }

  @Test
  public void test_diag_template_diffing_color_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-template-diffing-color.cpp");
    // REQUIRES: ansi-escape-sequences
    if (!CHECK_REQUIRES("ansi-escape-sequences")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -fcolor-diagnostics ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-template-diffing-color.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-template-diffing-color.cpp
    RUN("not %clang_cc1 -fsyntax-only -std=c++11 -fcolor-diagnostics %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -fcolor-diagnostics -fdiagnostics-show-template-tree ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-template-diffing-color.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-template-diffing-color.cpp -check-prefix=TREE
    RUN("not %clang_cc1 -fsyntax-only -std=c++11 -fcolor-diagnostics -fdiagnostics-show-template-tree %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=TREE");
  }

  @Test
  public void test_diag_template_diffing_cxx98_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-template-diffing-cxx98.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-template-diffing-cxx98.cpp -std=c++98 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-template-diffing-cxx98.cpp
    RUN("not %clang_cc1 -fsyntax-only %s -std=c++98 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_diag_trailing_null_bytes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-trailing-null-bytes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-trailing-null-bytes.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-trailing-null-bytes.cpp
    RUN("not %clang_cc1 -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_diag_verify_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-verify.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-verify.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/diag-verify.cpp
    RUN("not %clang_cc1 -fsyntax-only -verify %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_diagnostic_crash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/diagnostic-crash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/diagnostic-crash.cpp
    RUN("%clang_cc1 -verify -fsyntax-only %s");
  }

  @Test
  public void test_driver_verify_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/driver-verify.c");
    // ${LLVM_SRC}/build/bin/clang -verify ${LLVM_SRC}/llvm/tools/clang/test/Misc/driver-verify.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/driver-verify.c
    RUN("not %clang -verify %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -verify ${LLVM_SRC}/llvm/tools/clang/test/Misc/driver-verify.c
    RUN("%clang -cc1 -verify %s");
  }

  @Test
  public void test_emit_html_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/emit-html.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/emit-html.c -emit-html -o -
    RUN(TestState.Failed, "%clang_cc1 %s -emit-html -o -");
  }

  @Test
  public void test_emit_html_insert_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/emit-html-insert.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/emit-html-insert.c -emit-html -o - | grep '>&lt; 10; }'
    RUN(TestState.Failed, "%clang_cc1 %s -emit-html -o -")./*|*/
      I("grep \">&lt; 10; }\"");
  }

  @Test
  public void test_error_limit_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/error-limit.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ferror-limit 1 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/error-limit.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/error-limit.c
    RUN("not %clang_cc1 -ferror-limit 1 -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_error_limit_multiple_notes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/error-limit-multiple-notes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ferror-limit 1 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/error-limit-multiple-notes.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/error-limit-multiple-notes.cpp
    RUN("not %clang_cc1 -ferror-limit 1 -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_freebsd_arm_size_t_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/freebsd-arm-size_t.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple arm-unknown-freebsd10.0 -verify ${LLVM_SRC}/llvm/tools/clang/test/Misc/freebsd-arm-size_t.c
    RUN("%clang_cc1 -triple arm-unknown-freebsd10.0 -verify %s");
  }

  @Test
  public void test_include_stack_for_note_flag_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/include-stack-for-note-flag.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-show-note-include-stack ${LLVM_SRC}/llvm/tools/clang/test/Misc/include-stack-for-note-flag.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/include-stack-for-note-flag.cpp -check-prefix=STACK
    RUN("not %clang_cc1 -fsyntax-only -fdiagnostics-show-note-include-stack %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=STACK");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fno-diagnostics-show-note-include-stack ${LLVM_SRC}/llvm/tools/clang/test/Misc/include-stack-for-note-flag.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/include-stack-for-note-flag.cpp -check-prefix=STACKLESS
    RUN("not %clang_cc1 -fsyntax-only -fno-diagnostics-show-note-include-stack %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=STACKLESS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fno-diagnostics-show-note-include-stack -fdiagnostics-show-note-include-stack ${LLVM_SRC}/llvm/tools/clang/test/Misc/include-stack-for-note-flag.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/include-stack-for-note-flag.cpp -check-prefix=STACK
    RUN("not %clang_cc1 -fsyntax-only -fno-diagnostics-show-note-include-stack -fdiagnostics-show-note-include-stack %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=STACK");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-show-note-include-stack -fno-diagnostics-show-note-include-stack ${LLVM_SRC}/llvm/tools/clang/test/Misc/include-stack-for-note-flag.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/include-stack-for-note-flag.cpp -check-prefix=STACKLESS
    RUN("not %clang_cc1 -fsyntax-only -fdiagnostics-show-note-include-stack -fno-diagnostics-show-note-include-stack %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=STACKLESS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/include-stack-for-note-flag.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/include-stack-for-note-flag.cpp -check-prefix=STACKLESS
    RUN("not %clang_cc1 -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=STACKLESS");
  }

  @Test
  public void test_integer_literal_printing_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/integer-literal-printing.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/integer-literal-printing.cpp -fsyntax-only -verify -std=c++11
    RUN("%clang_cc1 %s -fsyntax-only -verify -std=c++11");
  }

  @Test
  public void test_interpreter_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/interpreter.c");
    // REQUIRES: native, examples
    if (!CHECK_REQUIRES("native, examples")) {
      return;
    }
    // clang-interpreter ${LLVM_SRC}/llvm/tools/clang/test/Misc/interpreter.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/interpreter.c
    RUN(TestState.Failed, "clang-interpreter %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_languageOptsOpenCL_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/languageOptsOpenCL.cl");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl ${LLVM_SRC}/llvm/tools/clang/test/Misc/languageOptsOpenCL.cl -verify -triple spir-unknown-unknown
    RUN("%clang_cc1 -x cl %s -verify -triple spir-unknown-unknown");
  }

  @Test
  public void test_macro_backtrace_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/macro-backtrace.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fmacro-backtrace-limit 5 ${LLVM_SRC}/llvm/tools/clang/test/Misc/macro-backtrace.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/macro-backtrace.c -check-prefix=CHECK-LIMIT
    RUN("%clang_cc1 -fsyntax-only -fmacro-backtrace-limit 5 %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=CHECK-LIMIT");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fno-caret-diagnostics ${LLVM_SRC}/llvm/tools/clang/test/Misc/macro-backtrace.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/macro-backtrace.c -check-prefix=CHECK-NO-CARETS
    RUN("%clang_cc1 -fsyntax-only -fno-caret-diagnostics %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=CHECK-NO-CARETS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-format vi ${LLVM_SRC}/llvm/tools/clang/test/Misc/macro-backtrace.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/macro-backtrace.c -check-prefix=CHECK-NOTE-FORMAT
    RUN("%clang_cc1 -fsyntax-only -fdiagnostics-format vi %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=CHECK-NOTE-FORMAT");
  }

  @Test
  public void test_message_length_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/message-length.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmessage-length 72 ${LLVM_SRC}/llvm/tools/clang/test/Misc/message-length.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/message-length.c
    RUN("not %clang_cc1 -fmessage-length 72 %s 2>&1")./*|*/
      I("FileCheck -strict-whitespace %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmessage-length 1 ${LLVM_SRC}/llvm/tools/clang/test/Misc/message-length.c
    RUN("not %clang_cc1 -fmessage-length 1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fmessage-length 8 ${LLVM_SRC}/llvm/tools/clang/test/Misc/message-length.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-DOT ${LLVM_SRC}/llvm/tools/clang/test/Misc/message-length.c
    RUN("not %clang_cc1 -fmessage-length 8 %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-DOT %s");
  }

  @Test
  public void test_nvptx_languageOptsOpenCL_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/nvptx.languageOptsOpenCL.cl");
    // REQUIRES: nvptx-registered-target
    if (!CHECK_REQUIRES("nvptx-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL ${LLVM_SRC}/llvm/tools/clang/test/Misc/nvptx.languageOptsOpenCL.cl -verify -triple nvptx-unknown-unknown
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL %s -verify -triple nvptx-unknown-unknown");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.1 ${LLVM_SRC}/llvm/tools/clang/test/Misc/nvptx.languageOptsOpenCL.cl -verify -triple nvptx-unknown-unknown
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.1 %s -verify -triple nvptx-unknown-unknown");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.2 ${LLVM_SRC}/llvm/tools/clang/test/Misc/nvptx.languageOptsOpenCL.cl -verify -triple nvptx-unknown-unknown
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.2 %s -verify -triple nvptx-unknown-unknown");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL2.0 ${LLVM_SRC}/llvm/tools/clang/test/Misc/nvptx.languageOptsOpenCL.cl -verify -triple nvptx-unknown-unknown
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL2.0 %s -verify -triple nvptx-unknown-unknown");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL ${LLVM_SRC}/llvm/tools/clang/test/Misc/nvptx.languageOptsOpenCL.cl -verify -triple nvptx-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL %s -verify -triple nvptx-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.1 ${LLVM_SRC}/llvm/tools/clang/test/Misc/nvptx.languageOptsOpenCL.cl -verify -triple nvptx-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.1 %s -verify -triple nvptx-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.2 ${LLVM_SRC}/llvm/tools/clang/test/Misc/nvptx.languageOptsOpenCL.cl -verify -triple nvptx-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.2 %s -verify -triple nvptx-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL2.0 ${LLVM_SRC}/llvm/tools/clang/test/Misc/nvptx.languageOptsOpenCL.cl -verify -triple nvptx-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL2.0 %s -verify -triple nvptx-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL ${LLVM_SRC}/llvm/tools/clang/test/Misc/nvptx.languageOptsOpenCL.cl -verify -triple nvptx64-unknown-unknown
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL %s -verify -triple nvptx64-unknown-unknown");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.1 ${LLVM_SRC}/llvm/tools/clang/test/Misc/nvptx.languageOptsOpenCL.cl -verify -triple nvptx64-unknown-unknown
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.1 %s -verify -triple nvptx64-unknown-unknown");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.2 ${LLVM_SRC}/llvm/tools/clang/test/Misc/nvptx.languageOptsOpenCL.cl -verify -triple nvptx64-unknown-unknown
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.2 %s -verify -triple nvptx64-unknown-unknown");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL2.0 ${LLVM_SRC}/llvm/tools/clang/test/Misc/nvptx.languageOptsOpenCL.cl -verify -triple nvptx64-unknown-unknown
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL2.0 %s -verify -triple nvptx64-unknown-unknown");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL ${LLVM_SRC}/llvm/tools/clang/test/Misc/nvptx.languageOptsOpenCL.cl -verify -triple nvptx64-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL %s -verify -triple nvptx64-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.1 ${LLVM_SRC}/llvm/tools/clang/test/Misc/nvptx.languageOptsOpenCL.cl -verify -triple nvptx64-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.1 %s -verify -triple nvptx64-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.2 ${LLVM_SRC}/llvm/tools/clang/test/Misc/nvptx.languageOptsOpenCL.cl -verify -triple nvptx64-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.2 %s -verify -triple nvptx64-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL2.0 ${LLVM_SRC}/llvm/tools/clang/test/Misc/nvptx.languageOptsOpenCL.cl -verify -triple nvptx64-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL2.0 %s -verify -triple nvptx64-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES");
  }

  @Test
  public void test_permissions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/permissions.cpp");
    // REQUIRES: shell
    if (!CHECK_REQUIRES("shell")) {
      return;
    }
    // umask 000
    RUN(TestState.Failed, "umask 000");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-bc ${LLVM_SRC}/llvm/tools/clang/test/Misc/permissions.cpp -o ${TEST_TEMP_DIR}/permissions.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-bc %s -o %t");
    // ls -l ${TEST_TEMP_DIR}/permissions.cpp.tmp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK000 ${LLVM_SRC}/llvm/tools/clang/test/Misc/permissions.cpp
    RUN(TestState.Failed, "ls -l %t")./*|*/
      I("FileCheck --check-prefix=CHECK000 %s");
    // umask 002
    RUN(TestState.Failed, "umask 002");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-bc ${LLVM_SRC}/llvm/tools/clang/test/Misc/permissions.cpp -o ${TEST_TEMP_DIR}/permissions.cpp.tmp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-bc %s -o %t");
    // ls -l ${TEST_TEMP_DIR}/permissions.cpp.tmp | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK002 ${LLVM_SRC}/llvm/tools/clang/test/Misc/permissions.cpp
    RUN(TestState.Failed, "ls -l %t")./*|*/
      I("FileCheck --check-prefix=CHECK002 %s");
  }

  @Test
  public void test_predefines_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/predefines.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c89 -ffreestanding -pedantic-errors ${LLVM_SRC}/llvm/tools/clang/test/Misc/predefines.c
    RUN("%clang_cc1 -fsyntax-only -verify -std=c89 -ffreestanding -pedantic-errors %s");
  }

  @Test
  public void test_r600_languageOptsOpenCL_cl() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl");
    // REQUIRES: amdgpu-registered-target
    if (!CHECK_REQUIRES("amdgpu-registered-target")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -target-cpu cayman
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL %s -verify -triple r600-unknown-unknown -target-cpu cayman");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.1 ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -target-cpu cayman
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.1 %s -verify -triple r600-unknown-unknown -target-cpu cayman");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.2 ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -target-cpu cayman
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.2 %s -verify -triple r600-unknown-unknown -target-cpu cayman");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL2.0 ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -target-cpu cayman
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL2.0 %s -verify -triple r600-unknown-unknown -target-cpu cayman");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu cayman
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL %s -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu cayman");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.1 ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu cayman
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.1 %s -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu cayman");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.2 ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu cayman
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.2 %s -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu cayman");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL2.0 ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu cayman
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL2.0 %s -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu cayman");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -target-cpu cypress
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL %s -verify -triple r600-unknown-unknown -target-cpu cypress");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.1 ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -target-cpu cypress
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.1 %s -verify -triple r600-unknown-unknown -target-cpu cypress");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.2 ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -target-cpu cypress
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.2 %s -verify -triple r600-unknown-unknown -target-cpu cypress");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL2.0 ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -target-cpu cypress
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL2.0 %s -verify -triple r600-unknown-unknown -target-cpu cypress");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu cypress
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL %s -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu cypress");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.1 ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu cypress
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.1 %s -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu cypress");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.2 ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu cypress
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.2 %s -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu cypress");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL2.0 ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu cypress
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL2.0 %s -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu cypress");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -target-cpu turks
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL %s -verify -triple r600-unknown-unknown -target-cpu turks");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.1 ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -target-cpu turks
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.1 %s -verify -triple r600-unknown-unknown -target-cpu turks");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.2 ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -target-cpu turks
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.2 %s -verify -triple r600-unknown-unknown -target-cpu turks");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL2.0 ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -target-cpu turks
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL2.0 %s -verify -triple r600-unknown-unknown -target-cpu turks");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu turks
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL %s -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu turks");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.1 ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu turks
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.1 %s -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu turks");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL1.2 ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu turks
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL1.2 %s -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu turks");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -x cl -cl-std=CL2.0 ${LLVM_SRC}/llvm/tools/clang/test/Misc/r600.languageOptsOpenCL.cl -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu turks
    RUN(TestState.Failed, "%clang_cc1 -x cl -cl-std=CL2.0 %s -verify -triple r600-unknown-unknown -Wpedantic-core-features -DTEST_CORE_FEATURES -target-cpu turks");
  }

  @Test
  public void test_reduced_diags_macros_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/reduced-diags-macros.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/reduced-diags-macros.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/reduced-diags-macros.cpp -strict-whitespace
    RUN("not %clang_cc1 -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s -strict-whitespace");
  }

  @Test
  public void test_reduced_diags_macros_backtrace_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/reduced-diags-macros-backtrace.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fmacro-backtrace-limit 0 ${LLVM_SRC}/llvm/tools/clang/test/Misc/reduced-diags-macros-backtrace.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/reduced-diags-macros-backtrace.cpp --check-prefix=ALL
    RUN("not %clang_cc1 -fsyntax-only -fmacro-backtrace-limit 0 %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix=ALL");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fmacro-backtrace-limit 2 ${LLVM_SRC}/llvm/tools/clang/test/Misc/reduced-diags-macros-backtrace.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/reduced-diags-macros-backtrace.cpp --check-prefix=SKIP
    RUN("not %clang_cc1 -fsyntax-only -fmacro-backtrace-limit 2 %s 2>&1")./*|*/
      I("FileCheck %s --check-prefix=SKIP");
  }

  @Test
  public void test_remap_file_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/remap-file.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -remap-file ${LLVM_SRC}/llvm/tools/clang/test/Misc/remap-file.c;${LLVM_SRC}/llvm/tools/clang/test/Misc/Inputs/remapped-file -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/remap-file.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-EXIST ${LLVM_SRC}/llvm/tools/clang/test/Misc/remap-file.c
    RUN("%clang_cc1 -remap-file \"%s;%S/Inputs/remapped-file\" -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-EXIST %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -remap-file ${LLVM_SRC}/llvm/tools/clang/test/Misc/nonexistent.c;${LLVM_SRC}/llvm/tools/clang/test/Misc/Inputs/remapped-file -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/nonexistent.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-NONEXIST ${LLVM_SRC}/llvm/tools/clang/test/Misc/remap-file.c
    RUN("%clang_cc1 -remap-file \"%S/nonexistent.c;%S/Inputs/remapped-file\" -fsyntax-only %S/nonexistent.c 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-NONEXIST %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -remap-file ${LLVM_SRC}/llvm/tools/clang/test/Misc/nonexistent.c;${LLVM_SRC}/llvm/tools/clang/test/Misc/Inputs/remapped-file-2 -remap-file ${LLVM_SRC}/llvm/tools/clang/test/Misc/nonexistent.h;${LLVM_SRC}/llvm/tools/clang/test/Misc/Inputs/remapped-file-3 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/nonexistent.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-HEADER ${LLVM_SRC}/llvm/tools/clang/test/Misc/remap-file.c
    RUN("%clang_cc1 -remap-file \"%S/nonexistent.c;%S/Inputs/remapped-file-2\" -remap-file \"%S/nonexistent.h;%S/Inputs/remapped-file-3\" -fsyntax-only %S/nonexistent.c 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-HEADER %s");
  }

  @Test
  public void test_serialized_diags_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags.c");
    // rm -f ${TEST_TEMP_DIR}/serialized-diags.c.tmp
    RUN(TestState.Failed, "rm -f %t");
    // ${LLVM_SRC}/build/bin/clang -Wall -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags.c --serialize-diagnostics ${TEST_TEMP_DIR}/serialized-diags.c.tmp.diag > /dev/null 2>&1
    RUN(TestState.Failed, "not %clang -Wall -fsyntax-only %s --serialize-diagnostics %t.diag > /dev/null 2>&1");
    // c-index-test -read-diagnostics ${TEST_TEMP_DIR}/serialized-diags.c.tmp.diag > ${TEST_TEMP_DIR}/serialized-diags.c.tmp 2>&1
    RUN(TestState.Failed, "c-index-test -read-diagnostics %t.diag > %t 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/serialized-diags.c.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags.c
    RUN(TestState.Failed, "FileCheck --input-file=%t %s");
  }

  @Test
  public void test_serialized_diags_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags.m");
    // rm -f ${TEST_TEMP_DIR}/serialized-diags.m.tmp
    RUN("rm -f %t");
    // ${LLVM_SRC}/build/bin/clang -Wall -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags.m --serialize-diagnostics ${TEST_TEMP_DIR}/serialized-diags.m.tmp.diag > /dev/null 2>&1
    RUN("not %clang -Wall -fsyntax-only %s --serialize-diagnostics %t.diag > /dev/null 2>&1");
    // c-index-test -read-diagnostics ${TEST_TEMP_DIR}/serialized-diags.m.tmp.diag > ${TEST_TEMP_DIR}/serialized-diags.m.tmp 2>&1
    RUN("c-index-test -read-diagnostics %t.diag > %t 2>&1");
    // ${LLVM_SRC}/build/bin/FileCheck '--input-file=${TEST_TEMP_DIR}/serialized-diags.m.tmp' ${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags.m
    RUN("FileCheck --input-file=%t %s");
  }

  @Test
  public void test_serialized_diags_driver_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-driver.c");
    // rm -f ${TEST_TEMP_DIR}/serialized-diags-driver.c.tmp
    RUN(TestState.Failed, "rm -f %t");
    // ${LLVM_SRC}/build/bin/clang -Wx-typoed-warning -Wall -fsyntax-only --serialize-diagnostics ${TEST_TEMP_DIR}/serialized-diags-driver.c.tmp.diag ${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-driver.c
    RUN(TestState.Failed, "%clang -Wx-typoed-warning -Wall -fsyntax-only --serialize-diagnostics %t.diag %s");
    // c-index-test -read-diagnostics ${TEST_TEMP_DIR}/serialized-diags-driver.c.tmp.diag 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-driver.c
    RUN(TestState.Failed, "c-index-test -read-diagnostics %t.diag 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_serialized_diags_frontend_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-frontend.c");
    // rm -f ${TEST_TEMP_DIR}/serialized-diags-frontend.c.tmp
    RUN("rm -f %t");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-frontend.c -Wblahblah --serialize-diagnostics ${TEST_TEMP_DIR}/serialized-diags-frontend.c.tmp > /dev/null 2>&1
    RUN("%clang -fsyntax-only %s -Wblahblah --serialize-diagnostics %t > /dev/null 2>&1");
    // c-index-test -read-diagnostics ${TEST_TEMP_DIR}/serialized-diags-frontend.c.tmp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-frontend.c
    RUN("c-index-test -read-diagnostics %t 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_serialized_diags_no_category_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-no-category.c");
    // rm -f ${TEST_TEMP_DIR}/serialized-diags-no-category.c.tmp
    RUN("rm -f %t");
    // ${LLVM_SRC}/build/bin/clang -ferror-limit=1 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-no-category.c --serialize-diagnostics ${TEST_TEMP_DIR}/serialized-diags-no-category.c.tmp > /dev/null 2>&1
    RUN("not %clang -ferror-limit=1 -fsyntax-only %s --serialize-diagnostics %t > /dev/null 2>&1");
    // c-index-test -read-diagnostics ${TEST_TEMP_DIR}/serialized-diags-no-category.c.tmp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-no-category.c
    RUN("c-index-test -read-diagnostics %t 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_serialized_diags_no_issue_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-no-issue.c");
    // ${LLVM_SRC}/build/bin/clang -Wall -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-no-issue.c --serialize-diagnostics ${TEST_TEMP_DIR}/serialized-diags-no-issue.c.tmp
    RUN("%clang -Wall -fsyntax-only %s --serialize-diagnostics %t");
    // c-index-test -read-diagnostics ${TEST_TEMP_DIR}/serialized-diags-no-issue.c.tmp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-no-issue.c
    RUN("c-index-test -read-diagnostics %t 2>&1")./*|*/
      I("FileCheck %s");
    // rm -f ${TEST_TEMP_DIR}/serialized-diags-no-issue.c.tmp
    RUN("rm -f  %t");
  }

  @Test
  public void test_serialized_diags_really_long_text_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-really-long-text.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-really-long-text.cpp -serialize-diagnostic-file ${TEST_TEMP_DIR}/serialized-diags-really-long-text.cpp.tmp.dia
    RUN("not %clang_cc1 -std=c++11 %s -serialize-diagnostic-file %t.dia");
    // c-index-test -read-diagnostics ${TEST_TEMP_DIR}/serialized-diags-really-long-text.cpp.tmp.dia 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-really-long-text.cpp
    RUN("c-index-test -read-diagnostics %t.dia 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_serialized_diags_single_issue_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-single-issue.c");
    // ${LLVM_SRC}/build/bin/clang -Wall -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-single-issue.c --serialize-diagnostics ${TEST_TEMP_DIR}/serialized-diags-single-issue.c.tmp
    RUN(TestState.Failed, "%clang -Wall -fsyntax-only %s --serialize-diagnostics %t");
    // c-index-test -read-diagnostics ${TEST_TEMP_DIR}/serialized-diags-single-issue.c.tmp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-single-issue.c
    RUN(TestState.Failed, "c-index-test -read-diagnostics %t 2>&1")./*|*/
      I("FileCheck %s");
    // rm -f ${TEST_TEMP_DIR}/serialized-diags-single-issue.c.tmp
    RUN(TestState.Failed, "rm -f %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -Wall -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-single-issue.c ${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-single-issue.c -serialize-diagnostic-file ${TEST_TEMP_DIR}/serialized-diags-single-issue.c.tmp
    RUN(TestState.Failed, "%clang_cc1 -Wall -fsyntax-only %s %s -serialize-diagnostic-file %t");
    // c-index-test -read-diagnostics ${TEST_TEMP_DIR}/serialized-diags-single-issue.c.tmp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-MULT ${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-single-issue.c
    RUN(TestState.Failed, "c-index-test -read-diagnostics %t 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-MULT %s");
    // rm -f ${TEST_TEMP_DIR}/serialized-diags-single-issue.c.tmp
    RUN(TestState.Failed, "rm -f %t");
  }

  @Test
  public void test_serialized_diags_stable_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-stable.c");
    // rm -f ${TEST_TEMP_DIR}/serialized-diags-stable.c.tmp
    RUN("rm -f %t");
    // ${LLVM_SRC}/build/bin/clang -Wall -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-stable.c --serialize-diagnostics ${TEST_TEMP_DIR}/serialized-diags-stable.c.tmp.dia > /dev/null 2>&1
    RUN("not %clang -Wall -fsyntax-only %s --serialize-diagnostics %t.dia > /dev/null 2>&1");
    // c-index-test -read-diagnostics ${TEST_TEMP_DIR}/serialized-diags-stable.c.tmp.dia 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-stable.c
    RUN("c-index-test -read-diagnostics %t.dia 2>&1")./*|*/
      I("FileCheck %s");
    // c-index-test -read-diagnostics ${LLVM_SRC}/llvm/tools/clang/test/Misc/Inputs/serialized-diags-stable.dia 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/serialized-diags-stable.c
    RUN("c-index-test -read-diagnostics %S/Inputs/serialized-diags-stable.dia 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_show_diag_options_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/show-diag-options.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/show-diag-options.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/show-diag-options.c -check-prefix=BASE
    RUN("%clang_cc1 -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=BASE");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-show-option ${LLVM_SRC}/llvm/tools/clang/test/Misc/show-diag-options.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/show-diag-options.c -check-prefix=OPTION
    RUN("%clang_cc1 -fsyntax-only -fdiagnostics-show-option %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=OPTION");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-show-option -Werror ${LLVM_SRC}/llvm/tools/clang/test/Misc/show-diag-options.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/show-diag-options.c -check-prefix=OPTION_ERROR
    RUN("not %clang_cc1 -fsyntax-only -fdiagnostics-show-option -Werror %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=OPTION_ERROR");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c89 -pedantic -fdiagnostics-show-option ${LLVM_SRC}/llvm/tools/clang/test/Misc/show-diag-options.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/show-diag-options.c -check-prefix=OPTION_PEDANTIC
    RUN("%clang_cc1 -fsyntax-only -std=c89 -pedantic -fdiagnostics-show-option %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=OPTION_PEDANTIC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-show-category id ${LLVM_SRC}/llvm/tools/clang/test/Misc/show-diag-options.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/show-diag-options.c -check-prefix=CATEGORY_ID
    RUN("%clang_cc1 -fsyntax-only -fdiagnostics-show-category id %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=CATEGORY_ID");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-show-category name ${LLVM_SRC}/llvm/tools/clang/test/Misc/show-diag-options.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/show-diag-options.c -check-prefix=CATEGORY_NAME
    RUN("%clang_cc1 -fsyntax-only -fdiagnostics-show-category name %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=CATEGORY_NAME");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fdiagnostics-show-option -fdiagnostics-show-category name -Werror ${LLVM_SRC}/llvm/tools/clang/test/Misc/show-diag-options.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/show-diag-options.c -check-prefix=OPTION_ERROR_CATEGORY
    RUN("not %clang_cc1 -fsyntax-only -fdiagnostics-show-option -fdiagnostics-show-category name -Werror %s 2>&1")./*|*/
      I("FileCheck %s -check-prefix=OPTION_ERROR_CATEGORY");
  }

  @Test
  public void test_tabstop_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/tabstop.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ftabstop 3 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/tabstop.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-3 -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/tabstop.c
    RUN("%clang_cc1 -ftabstop 3 -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-3 -strict-whitespace %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ftabstop 4 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/tabstop.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-4 -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/tabstop.c
    RUN("%clang_cc1 -ftabstop 4 -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-4 -strict-whitespace %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ftabstop 5 -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/tabstop.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -check-prefix=CHECK-5 -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/tabstop.c
    RUN("%clang_cc1 -ftabstop 5 -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck -check-prefix=CHECK-5 -strict-whitespace %s");
  }

  @Test
  public void test_target_parser_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/target-parser.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple armv7--- -target-cpu not-a-cpu -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/Misc/target-parser.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/target-parser.c
    RUN("not %clang_cc1 -triple armv7--- -target-cpu not-a-cpu -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_thinlto_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/thinlto.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -flto=thin -emit-llvm-bc < ${LLVM_SRC}/llvm/tools/clang/test/Misc/thinlto.c | llvm-bcanalyzer -dump | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/thinlto.c
    RUN(TestState.Failed, "%clang_cc1 -flto=thin -emit-llvm-bc < %s")./*|*/
      I("llvm-bcanalyzer -dump")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_unnecessary_elipses_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/unnecessary-elipses.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fmessage-length 80 ${LLVM_SRC}/llvm/tools/clang/test/Misc/unnecessary-elipses.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/unnecessary-elipses.cpp
    RUN("%clang_cc1 -fsyntax-only -fmessage-length 80 %s 2>&1")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_unprintable_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/unprintable.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/Misc/unprintable.c -fmessage-length 40 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/unprintable.c
    RUN(TestState.Failed, "not %clang_cc1 %s -fmessage-length 40 2>&1")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_verify_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/verify.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/Misc/verify.c
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_warn_in_system_header_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/warn-in-system-header.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -isystem ${LLVM_SRC}/llvm/tools/clang/test/Misc ${LLVM_SRC}/llvm/tools/clang/test/Misc/warn-in-system-header.c -fsyntax-only -verify
    RUN("%clang_cc1 -isystem %S %s -fsyntax-only -verify");
  }

  @Test
  public void test_warn_sysheader_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/warn-sysheader.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -DA ${LLVM_SRC}/llvm/tools/clang/test/Misc/warn-sysheader.cpp
    RUN("%clang_cc1 -verify -fsyntax-only -DA %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -DB -Wold-style-cast ${LLVM_SRC}/llvm/tools/clang/test/Misc/warn-sysheader.cpp
    RUN("%clang_cc1 -verify -fsyntax-only -DB -Wold-style-cast %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -DC -Wold-style-cast -Wsystem-headers ${LLVM_SRC}/llvm/tools/clang/test/Misc/warn-sysheader.cpp
    RUN("%clang_cc1 -verify -fsyntax-only -DC -Wold-style-cast -Wsystem-headers %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -DD -Wold-style-cast -Wsystem-headers -Werror ${LLVM_SRC}/llvm/tools/clang/test/Misc/warn-sysheader.cpp
    RUN("%clang_cc1 -verify -fsyntax-only -DD -Wold-style-cast -Wsystem-headers -Werror %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -fsyntax-only -DE -Wold-style-cast -Wsystem-headers -Werror=old-style-cast ${LLVM_SRC}/llvm/tools/clang/test/Misc/warn-sysheader.cpp
    RUN("%clang_cc1 -verify -fsyntax-only -DE -Wold-style-cast -Wsystem-headers -Werror=old-style-cast %s");
  }

  @Test
  public void test_warning_flags_enabled_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c");
    // diagtool show-enabled ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c
    RUN(TestState.Failed, "diagtool show-enabled %s")./*|*/
      I("FileCheck %s");
    // diagtool show-enabled -Wno-everything ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c | ${LLVM_SRC}/build/bin/count 0
    RUN(TestState.Failed, "diagtool show-enabled -Wno-everything %s")./*|*/
      I("count 0");
    // diagtool show-enabled -Wno-everything -Wobjc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-WARN ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c
    RUN(TestState.Failed, "diagtool show-enabled -Wno-everything -Wobjc-root-class %s")./*|*/
      I("FileCheck -check-prefix CHECK-WARN %s");
    // diagtool show-enabled -Wno-everything -Werror=objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-ERROR ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c
    RUN(TestState.Failed, "diagtool show-enabled -Wno-everything -Werror=objc-root-class %s")./*|*/
      I("FileCheck -check-prefix CHECK-ERROR %s");
    // diagtool show-enabled -Wno-everything -Wfatal-errors=objc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-FATAL ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c
    RUN(TestState.Failed, "diagtool show-enabled -Wno-everything -Wfatal-errors=objc-root-class %s")./*|*/
      I("FileCheck -check-prefix CHECK-FATAL %s");
    // diagtool show-enabled --no-levels -Wno-everything -Wobjc-root-class ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-NO-LEVELS ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c
    RUN(TestState.Failed, "diagtool show-enabled --no-levels -Wno-everything -Wobjc-root-class %s")./*|*/
      I("FileCheck -check-prefix CHECK-NO-LEVELS %s");
    // diagtool show-enabled --no-levels -Wno-conversion -Wenum-conversion ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix CHECK-ENUM-CONVERSION ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c
    RUN(TestState.Failed, "diagtool show-enabled --no-levels -Wno-conversion -Wenum-conversion %s")./*|*/
      I("FileCheck --check-prefix CHECK-ENUM-CONVERSION %s");
    // diagtool show-enabled --no-levels ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix CHECK-ENUM-CONVERSION ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c
    RUN(TestState.Failed, "diagtool show-enabled --no-levels %s")./*|*/
      I("FileCheck --check-prefix CHECK-ENUM-CONVERSION %s");
    // diagtool show-enabled --no-levels -Wno-conversion ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix CHECK-NO-ENUM-CONVERSION ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c
    RUN(TestState.Failed, "diagtool show-enabled --no-levels -Wno-conversion %s")./*|*/
      I("FileCheck --check-prefix CHECK-NO-ENUM-CONVERSION %s");
    // diagtool show-enabled --no-levels -Wno-parentheses -Wshift-op-parentheses ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix CHECK-SHIFT-OP-PARENTHESES ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c
    RUN(TestState.Failed, "diagtool show-enabled --no-levels -Wno-parentheses -Wshift-op-parentheses %s")./*|*/
      I("FileCheck --check-prefix CHECK-SHIFT-OP-PARENTHESES %s");
    // diagtool show-enabled --no-levels ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix CHECK-SHIFT-OP-PARENTHESES ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c
    RUN(TestState.Failed, "diagtool show-enabled --no-levels %s")./*|*/
      I("FileCheck --check-prefix CHECK-SHIFT-OP-PARENTHESES %s");
    // diagtool show-enabled --no-levels -Wno-parentheses ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c | ${LLVM_SRC}/build/bin/FileCheck --check-prefix CHECK-NO-SHIFT-OP-PARENTHESES ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-enabled.c
    RUN(TestState.Failed, "diagtool show-enabled --no-levels -Wno-parentheses %s")./*|*/
      I("FileCheck --check-prefix CHECK-NO-SHIFT-OP-PARENTHESES %s");
  }

  @Test
  public void test_warning_flags_tree_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-tree.c");
    // diagtool tree | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-tree.c
    RUN(TestState.Failed, "diagtool tree")./*|*/
      I("FileCheck -strict-whitespace %s");
    // diagtool tree -Weverything | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-tree.c
    RUN(TestState.Failed, "diagtool tree -Weverything")./*|*/
      I("FileCheck -strict-whitespace %s");
    // diagtool tree everything | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-tree.c
    RUN(TestState.Failed, "diagtool tree everything")./*|*/
      I("FileCheck -strict-whitespace %s");
    // diagtool tree -Wthis-is-not-a-valid-flag
    RUN(TestState.Failed, "not diagtool tree -Wthis-is-not-a-valid-flag");
    // diagtool tree -Wgnu | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace -check-prefix CHECK-GNU ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-tree.c
    RUN(TestState.Failed, "diagtool tree -Wgnu")./*|*/
      I("FileCheck -strict-whitespace -check-prefix CHECK-GNU %s");
    // diagtool tree --flags-only -Wgnu | ${LLVM_SRC}/build/bin/FileCheck -check-prefix CHECK-FLAGS-ONLY ${LLVM_SRC}/llvm/tools/clang/test/Misc/warning-flags-tree.c
    RUN(TestState.Failed, "diagtool tree --flags-only -Wgnu")./*|*/
      I("FileCheck -check-prefix CHECK-FLAGS-ONLY %s");
  }

  @Test
  public void test_win32_macho_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/win32-macho.c");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -target x86_64-pc-win32-macho ${LLVM_SRC}/llvm/tools/clang/test/Misc/win32-macho.c
    RUN("%clang -fsyntax-only -target x86_64-pc-win32-macho %s");
  }

  @Test
  public void test_working_directory_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/working-directory.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -working-directory ${LLVM_SRC}/llvm/tools/clang/test/Misc working-directory.c -IInputs -fsyntax-only
    RUN("%clang_cc1 -working-directory %S working-directory.c -IInputs -fsyntax-only");
  }

  @Test
  public void test_wrong_encoding_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/wrong-encoding.c");
    // REQUIRES: asserts
    if (!CHECK_REQUIRES("asserts")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-unused-value ${LLVM_SRC}/llvm/tools/clang/test/Misc/wrong-encoding.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/wrong-encoding.c
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -Wno-unused-value %s 2>&1")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_wrong_encoding2_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Misc/wrong-encoding2.c");
    // REQUIRES: asserts
    if (!CHECK_REQUIRES("asserts")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fmessage-length 100 ${LLVM_SRC}/llvm/tools/clang/test/Misc/wrong-encoding2.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Misc/wrong-encoding2.c
    RUN("%clang_cc1 -fsyntax-only -fmessage-length 100 %s 2>&1")./*|*/
      I("FileCheck -strict-whitespace %s");
  }
  
}
