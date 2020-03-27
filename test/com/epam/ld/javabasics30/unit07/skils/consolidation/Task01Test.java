package com.epam.ld.javabasics30.unit07.skils.consolidation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task01Test {

    private static final int TESTCASE_INPUTDATA = 0;
    private static final int TESTCASE_ASSERTION = 1;
    private static final int[][][][] TASK_A_TEST_CASES =
            { // first level - testcases array
                    { // second level - 2 elements array, first - input matrix, second - assertion
                            { // input matrix
                                    {   1,   2,   3,   4},
                                    {   5,   6,   7,   8},
                                    {   9,  10,  11,  12}
                            },
                            { // assertion
                                    {0, 0, 0}
                            }
                    },
                    {
                            {
                                    {  -1,   2,  -3,   4},
                                    {   5,  -6,   7,  -8},
                                    {  -9,  10,  11, -12}
                            },
                            {
                                    {-4, -14, -21}
                            }
                    }
            };

    private static final int[][][][] TASK_B_TEST_CASES =
            { // first level - testcases array
                    { // second level - 2 elements array, first - input matrix, second - assertion
                            { // input matrix
                                    {   1,   2,   3,   4},
                                    {   5,   6,   7,   8},
                                    {   9,  10,  11,  12}
                            },
                            { // assertion
                                    {4, 8, 12}
                            }
                    },
                    {
                            {
                                    {  -1,   2,  -3,   4},
                                    {   5,  -6,   7,  -8},
                                    {  -9,  10,  11, -12}
                            },
                            {
                                    {4, 7, 11}
                            }
                    }
            };

    private static final int[][][][] TASK_C_TEST_CASES =
            { // first level - testcases array
                    { // second level - 2 elements array, first - input matrix, second - assertion
                            { // input matrix
                                    {   1,   2,   3,   4},
                                    {   5,   6,   7,   8},
                                    {   9,  10,  11,  12}
                            },
                            { // assertion
                                    {  12,   2,   3,   4},
                                    {   5,   6,   7,   8},
                                    {   9,  10,  11,   1}
                            }
                    },
                    {
                            {
                                    {  -1,   2,  -3,   4},
                                    {   5,  -6,   7,  -8},
                                    {  -9,  10,  11, -12}
                            },
                            {
                                    {  -1,   2,  -3,   4},
                                    {   5,  -6,   7,  -8},
                                    {  -9,  10, -12,  11}
                            }
                    }
            };

    @Test
    void taskA() {
        int i = 0;
        for (int[][][] testCase : TASK_A_TEST_CASES) {
            Assertions.assertArrayEquals(testCase[TESTCASE_ASSERTION][0], Task01.taskA(testCase[TESTCASE_INPUTDATA]), String.format("Test case taskA#%d", ++i));
        }
    }

    @Test
    void taskB() {
        int i = 0;
        for (int[][][] testCase : TASK_B_TEST_CASES) {
            Assertions.assertArrayEquals(testCase[TESTCASE_ASSERTION][0], Task01.taskB(testCase[TESTCASE_INPUTDATA]), String.format("Test case taskB#%d", ++i));
        }
    }

    @Test
    void taskC() {
        int i = 0;
        for (int[][][] testCase : TASK_C_TEST_CASES) {
            Assertions.assertArrayEquals(testCase[TESTCASE_ASSERTION], Task01.taskC(testCase[TESTCASE_INPUTDATA]), String.format("Test case taskC#%d", ++i));
        }
    }
}