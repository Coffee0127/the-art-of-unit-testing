package com.osherove.ch3;

import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class LogAnalyzerTest {

    public static class NonParameterizedTest {

        @Rule
        public ExpectedException thrown = ExpectedException.none();

        @Test
        public void IsValidLogFileName_BadExtension_ReturnsFalse() {
            // 單元測試包含了三個行為 (3A)
            // 準備 (Arrange) 物件
            LogAnalyzer analyzer = makeAnalyzer(false);

            // 操作 (Act) 物件
            boolean result = analyzer.isValidLogFileName("filewithbadextension.foo");

            // 驗證 (Assert) 某件事符合預期
            Assert.assertFalse(result);
        }

        @Test
        public void IsValidLogFileName_GoodExtensionUppercase_ReturnsTrue() {
            LogAnalyzer analyzer = makeAnalyzer(true);

            boolean result = analyzer.isValidLogFileName("filewithgoodextension.SLF");

            Assert.assertTrue(result);
        }

        @Test
        public void IsValidLogFileName_GoodExtensionLowercase_ReturnsTrue() {
            LogAnalyzer analyzer = makeAnalyzer(true);

            boolean result = analyzer.isValidLogFileName("filewithgoodextension.slf");

            Assert.assertTrue(result);
        }

        // 因驗證邏輯已改由 IExtensionManager 處理，故先忽略此測試
        @Ignore
        // 不推薦使用 expected，因為無法確認是否為預期行數拋出例外
        @Test/*(expected = IllegalArgumentException.class)*/
        public void IsValidLogFileName_EmptyFileName_ThrowsException() {
            // 改使用 org.junit.rules.ExpectedException
            thrown.expect(IllegalArgumentException.class);
            // 不需要做到精確比對
            thrown.expectMessage(StringContains.containsString("filename has to be provided"));

            LogAnalyzer analyzer = makeAnalyzer(true);
            analyzer.isValidLogFileName("");
        }

        @Test
        public void IsValidLogFileName_WhenCalled_ChangesWasLastFileNameValid() {
            LogAnalyzer la = makeAnalyzer(false);

            la.isValidLogFileName("badname.foo");

            Assert.assertFalse(la.isWasLastFileNameValid());
        }

        @Test
        public void IsValidFileName_ExtManagerThrowsException_ReturnsFalse() {
            FakeExtensionManager myFakeManager = new FakeExtensionManager();
            myFakeManager.willThrow = new RuntimeException("this is fake");

            LogAnalyzer log = new LogAnalyzer(myFakeManager);
            boolean result = log.isValidLogFileName("anything.anyextension");
            Assert.assertFalse(result);
        }
    }

    private static LogAnalyzer makeAnalyzer(boolean willBeValid) {
        FakeExtensionManager myFakeManager = new FakeExtensionManager();
        myFakeManager.willBeValid = willBeValid;
        return new LogAnalyzer(myFakeManager);
    }

    @RunWith(Parameterized.class)
    public static class ParameterizedTest {
        private String file;

        public ParameterizedTest(String file) {
            this.file = file;
        }

        @Parameters
        public static Collection<String> data() {
            return Arrays.asList(
                "filewithgoodextension.SLF",
                "filewithgoodextension.slf"
            );
        }

        @Test
        public void IsValidLogFileName_ValidExtensions_ReturnsTrue() {
            LogAnalyzer analyzer = makeAnalyzer(true);

            boolean result = analyzer.isValidLogFileName(this.file);

            Assert.assertTrue(result);
        }
    }

    @RunWith(Parameterized.class)
    public static class Parameterized_WithCheckTest {
        private String file;
        private boolean expected;

        public Parameterized_WithCheckTest(String file, boolean expected) {
            this.file = file;
            this.expected = expected;
        }

        @Parameters(name = "file {0} => result is {1}")
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][] {
                { "filewithgoodextension.SLF", true },
                { "filewithgoodextension.slf", true },
                { "filewithbadextension.foo", false }
            });
        }

        @Test
        public void IsValidLogFileName_VariousExtensions_ChecksThem() {
            LogAnalyzer analyzer = makeAnalyzer(this.expected);

            boolean result = analyzer.isValidLogFileName(this.file);

            Assert.assertEquals(this.expected, result);
        }
    }

    private static class FakeExtensionManager implements IExtensionManager {

        public boolean willBeValid = false;
        public RuntimeException willThrow = null;

        @Override
        public boolean isValid(String fileName) {
            if (willThrow != null) {
                throw willThrow;
            }
            return willBeValid;
        }
    }

}
