package org.example.dsa;

import org.example.java8.SampleFuncInterface;
import org.example.utils.UtilityProvider;
import org.example.yamltoobject.YamlToObject;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class DsaMain {


    public static void main(String[] args) throws IOException {
        System.out.println("TYY");


    }

    // overflow
    // System.out.println(printIterativePower(102,5));
    private static int printIterativePower(int a, int b){
        int ans = 1;
        while (b > 0){
            if((b&1)==1){
                ans = ans*a;
            }
            b = b>>1;
            a=a*a;
        }
        return ans;
    }

    /*
    BigDecimal b = new BigDecimal(1);
        b = BigDecimal.valueOf(Math.floor(Math.pow(102,5))); //11040808032
        System.out.println(b);
     */

    // System.out.println(modInverseBruteFruce(3,11));
    /*
    (a*b)%m=1
    ((a mod m)*(b mod m))%m = 1
     */
    public static int modInverseBruteFruce(int a, int m)
    {
        int smallestModularMultiplicativeInverse = -1;

        a = a%m;
        for(int x=1; x<m; x++){
            if((a*x)%m==1){
                smallestModularMultiplicativeInverse = x;
            }
            if(smallestModularMultiplicativeInverse!=-1){
                break;
            }
        }

        return smallestModularMultiplicativeInverse;
    }

    /*
    a*b mod m = ((a%m)*(b%m))%m
     */
    static long multiplicationUnderModulo(long a, long b) {
        long m = (int) Math.floor(Math.pow(10, 9.0) + 7.0);
        return ((a % m) * (b % m)) % m;
    }

    /*
    addition-under-modulo (a+b)modm = (a mod m + b mod m) mod m;
     */
    private static long additionUnderModulo(long a, long b) {
        long aa = 8279685334796349382l;
        long bb = 3890369874501826197l;
        int m = (int) Math.floor(Math.pow(10, 9.0) + 7.0);
        System.out.println(((a % m) + (b % m)) % m);
        return ((a % m) + (b % m)) % m;
    }

    /*
    https://www.geeksforgeeks.org/batch/dsa-self-paced/track/DSASP-Mathematics/problem/addition-under-modulo
    long a = 9223372036854775807l;
        long b = 9223372036854775807l;

        int m = (int) (Math.pow(10,9.0)+7.0);

        System.out.println(a%m);
        System.out.println(b%m);
        System.out.println((a%m)+(b%m)); //582344006 --> incorrect o/p
        System.out.println((a+b)%m); //-2  --> overflow

     */

    //  System.out.println(geometricSeries(1,2,5));
    public static int geometricSeries(int firstTerm, int secondTerm, int nthTerm) {
        double ratio = (double) secondTerm / firstTerm;
        // formula for nth term: A = firstTerm(Math.pow(ratio, nthTerm-1))
        return (firstTerm * ((int) (Math.pow(ratio, nthTerm - 1))));

    }

    public int exactly3DivisorsLessTimeComplexity(int N) {
        int count = 0;
        for (int i = 2; i * i <= N; i++) {
            if (isPrimeEfficient(i)) {
                count += 1;
            }
        }
        return count;
    }


    public int exactly3Divisors(int N) {
        int count = 0;

        // Seive's algorithm
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i] == true) {
                for (int j = i * 2; j <= N; j = j + i) {
                    isPrime[j] = false;
                }
                count += 1;
            }
        }

        return count;
    }
/*    public int exactly3Divisors(int N)
    {
        // Seive's algorithm
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i=2; i*i<=N; i++){
            if(isPrime[i]==true){
                for(int j=i*2; j<=N; j=j+i){
                    isPrime[j]=false;
                }
            }
        }

        List<Integer> divisorsCount = new ArrayList<>();

        for(int i=2; i*i<=N; i++){
            if(isPrime[i]==true){
                divisorsCount.add(i*i);
            }
        }


        return divisorsCount.size();
    }*/
    /*
    public int exactly3Divisors(int N)
    {
        int count = 0;
        //Your code here
        for(int i=0; i<N; i++){
            List<Integer> divisors = getDivisors(i);
            if(divisors.size()==3){
                count+=1;
            }
        }
        return count;
    }

    public List<Integer> getDivisors(int N){
        List<Integer> divisors = new ArrayList<>();

        for(int i=1; i*i<=N; i++){
            if(N%i==0){
                divisors.add(i);
                if(i!=N/i){
                    divisors.add(N/i);
                }
            }
        }
        return divisors;
    }
     */


    /*
        assume total 5 request  ->  1 success update in fid1, 1 success update in fid2, 1 move in fid3, 1 move in fid4, 1 failed in fid5

        List<MessageBean> messageBeanListBeforeUpdate = {m1, m2, m3, m4, m5};
        List<FolderBaseBean> folderBaseBeanListBeforeUpdate = {fid1, fid2, null, null, fid5};
        List<FolderBaseBean> moveFolderBaseBeanListBeforeUpdate = {null, nullm fid3, fid4, null};

        List<MessageBean> messageBeanListAfterUpdate = {m1, m2, m3, m4, m5};
        List<FolderBaseBean> folderBaseBeanListAfterUpdate = {fid1, fid2, null, null, fid5};
        List<FolderBaseBean> moveFolderBaseBeanListAfterUpdate = {null, nullm fid3, fid4, null};

        List<MessageBean> successMessageBeanList = {null, };
        ----
        Map of FolderId, count.
        Iterate the Request.
        get index of successMessageList && moveList
        if(successMessageList!=null && moveList!=null){
            moveMap.put(folderId, +1);
        }else if(successMessageList!=null){
            updateMap.put(folderId, +1);
        }
    Map<Integer, Integer> updateMap = new ConcurrentHashMap<>();
    Map<Integer, Integer> moveMap = new ConcurrentHashMap<>();
  ----------------
        List<Message> messageArrayList = new LinkedList<>();
        messageArrayList.add(null);
        messageArrayList.add(null);
        messageArrayList.add(null);
        System.out.println(messageArrayList.size());
         */
    //System.out.println(countDigitsOffactorialUsingLog(10));
    private static int countDigitsOffactorialUsingLog(int n) {
        if (n < 0)
            return 0;

        // base case
        if (n <= 1)
            return 1;

        // else iterate through n and calculate the
        // value
        double digits = 0;
        for (int i = 2; i <= n; i++)
            digits += Math.log10(i);

        return (int) (Math.floor(digits)) + 1;
    }

    private static BigDecimal factorial(BigDecimal N) {

        BigDecimal one = new BigDecimal(1);
        BigDecimal zero = new BigDecimal(0);


        return one;


    }

/*
List<Message> messageArrayList = new LinkedList<>();
        messageArrayList.add(null);
        messageArrayList.add(null);
        messageArrayList.add(null);

        for(int i=0;i<messageArrayList.size(); i++){
            System.out.println(messageArrayList.get(i));
        }
 */
    /*
BigDecimal one = new BigDecimal(1);
        BigDecimal ten = new BigDecimal(10);

        BigDecimal count = new BigDecimal(0);

        while(f.compareTo(new BigDecimal(0))>0){
            count = count.add(one);
            f = f.divide(ten, 3);
        }
        return count.intValueExact();
     */

    /* BigDecimal one = new BigDecimal(3628800);
        BigDecimal two = new BigDecimal(10);

        while(one.compareTo(new BigDecimal(0))==1){
            one = one.divide(two, RoundingMode.FLOOR);
            System.out.println(one);
        }

    /*
    String count = String.valueOf(factoriall(10000));
    System.out.println(count.length()); //35660
     */

    /*
    BigDecimal b = factoriall(10); //3628800
    System.out.println(digitCount(b));
     */
    private static BigDecimal factoriall(int N) {
        BigDecimal f = new BigDecimal("1");
        while (N > 0) {
            f = f.multiply(BigDecimal.valueOf(N));
            N = N - 1;
        }
        return f;
    }

    private static int digitCountInt(int n) {
        int count = 0;
        while (n > 0) {
            count = count + 1;
            n = n / 10;
        }
        return count;
    }

    private static BigDecimal digitCount(BigDecimal n) {
        BigDecimal count = new BigDecimal(0);
        while ((n.compareTo(new BigDecimal(0))) > 0) {
            count = count.add(BigDecimal.valueOf(1));
            n = n.divide(BigDecimal.valueOf(10), RoundingMode.FLOOR);
        }
        return count;
    }

    public static void runFunctionsAndCalculateTimeTaken(SampleFuncInterface sampleFuncInterface, int n) {
        System.out.println("**********  " + sampleFuncInterface.getClass().descriptorString() + "  **********");
        Instant start = Instant.now();

        sampleFuncInterface.sampleMethod(n);

        Instant end = Instant.now();
        Duration difference = Duration.between(start, end);
        System.out.println("Time taken s :" + (difference.toSeconds()));
        System.out.println("Time taken ms :" + (difference.toMillis()));
        System.out.println("Time taken ns :" + (difference.toNanos()));
    }


    /*
    Math.floor()  -->  to round to upper value
    Math.ceil()  -->  to round to lower value
     */
    private static ArrayList<Integer> quadraticRoots(int a, int b, int c) {
        /*int a=1;
        int b=-7;
        int c=12;*/

        /*int a=752;
        int b=904;
        int c=164;*/
        // code here
        ArrayList<Integer> roots = new ArrayList<>();
        double discriminant = (b * b) - (4.0 * a * c);

        if (discriminant > -1) {
            double real = (-b) / (2.0 * a);
            double imaginary = Math.sqrt(discriminant) / (2.0 * a);

            double firstRoot = real + imaginary;
            double secondRoot = real - imaginary;

            if (firstRoot > secondRoot) {
                roots.add((int) Math.floor(firstRoot));
                roots.add((int) Math.floor(secondRoot));
            } else {
                roots.add((int) Math.floor(secondRoot));
                roots.add((int) Math.floor(firstRoot));
            }
        } else {
            roots.add(-1);
        }
        return roots;
    }

    /*
    for(int i=0; i<10; i++){
            System.out.println(1<<31);//-2147483648
        }
     */
//printBinaryValue(59049);
    private static void printBinaryValue(long n) {
        if (n > 1)
            printBinaryValue(n / 2);

        /* step 2 */
        System.out.print(n % 2);
    }

    /*
    SampleFuncInterface sampleFuncInterface = Main::seiveAlgorithm;
    runFunctionsAndCalculateTimeTaken(sampleFuncInterface, 13);
     */
    private static void seiveAlgorithm(int n) {
        boolean[] isPrimeArray = new boolean[n + 1];
        Arrays.fill(isPrimeArray, true);

        for (int index = 2; index <= n; index++) {
            if (DsaMain.isPrimeEfficient(index)) {
                for (int j = index * index; j <= n; j = index + j) {
                    isPrimeArray[j] = false;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            System.out.println(i + "-->" + isPrimeArray[i]);
        }
    }


    /*
    SampleFuncInterface sampleFuncInterface = Main::printDivisors;
    runFunctionsAndCalculateTimeTaken(sampleFuncInterface, 450);
     */
    private static void printDivisors(int n) {
        for (int index = 1; index * index <= n; index++) {
            if (n % index == 0) {
                System.out.print("(");
                System.out.print(index + ",");
                if (index != (n / index)) {
                    System.out.print(n / index);
                    System.out.print(")");
                }
            }
            System.out.println();
        }
    }

    /*
    SampleFuncInterface sampleFuncInterfacePrimeEfficient = Main::isPrimeEfficient;
    SampleFuncInterface sampleFuncInterfacePrime = Main::isPrime;

    System.out.println(runFunctionsAndCalculateTimeTaken(sampleFuncInterfacePrimeEfficient, 46749981));
    System.out.println(runFunctionsAndCalculateTimeTaken(sampleFuncInterfacePrime, 46749981));
    */
    public static boolean isPrimeEfficient(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int index = 5; (index * index) <= n; index = index + 6) {
            if ((n % index == 0) || (n % (index + 2) == 0)) {
                return false;
            }
        }
        return true;
    }


    /*
    private static final String URI_YM_REQUEST_ID = genAndLogYmReqId();
    System.out.println(URI_YM_REQUEST_ID);  -->  8b9d744b-6874-49a2-bee2-1fab4039cb80
    System.out.println(URI_YM_REQUEST_ID);  -->  8b9d744b-6874-49a2-bee2-1fab4039cb80
     */
    public static String genAndLogYmReqId() {
        return UUID.randomUUID().toString();
    }

    /*
    for(int i=0;i<233;i++){
            if(isPrime(i)){
                System.out.println(i);
            }

        }
     */
    // System.out.println(isPrime(23));  --> 14000
    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        int index;
        for (index = 2; index < n; index++) {
            if (n % index == 0) {
                return false;
            }
        }
        return true;
    }

    private static void getLCM() {
        // LCM(a,b) = (a*b)/GCD(a,b)
    }

    // System.out.println(getGCDRecursion(15, 25));  -->  18000
    private static int getGCDRecursion(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCDRecursion(b, a % b);
    }


    //System.out.println(getGCD(15, 25));  -->  17000
    private static int getGCD(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    // System.out.println(getGCDNaive(15, 25));  -->  24000
    private static int getGCDNaive(int a, int b) {
        int min = Math.min(a, b);
        while (min > 0) {
            if (a % min == 0 && b % min == 0) {
                return min;
            }
            min--;
        }
        return min;
    }


    /*
    5  -> 0     -> 120
    10 -> 00    -> 3628800
    15 -> 000   -> 1307674368000
    20 -> 0000  -> 2432902008176640000
    25 ->       -> 15511210043330985984000000
     */
    // findTrailingZeroInFactorial(25); ------> 23000
    private static int findTrailingZeroInFactorial(int n) {
        int numberOfZeros = 0;

        int index;
        for (index = 5; index <= n; index = index * 5) {
            numberOfZeros = numberOfZeros + n / index;
        }
        return numberOfZeros;
    }


    // factorialByRecursion(5) --> 5 ms (OR) 6154000 ns
    private static long factorialByRecursion(int n) {
        if (n == 0) {
            return 1l;
        }
        System.out.println("factorialByRecursion" + n);
        return n * factorialByRecursion(n - 1);
    }
    /*
    factorialByRecursion5
    factorialByRecursion4
    factorialByRecursion3
    factorialByRecursion2
    factorialByRecursion1
    120
     */

    // System.out.println(factorial(25));
    // System.out.println(factorial(5)); ---> 0 ms (OR) 29000 ns
    private static BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(String.format("Invalid input :%d", n));
        }
        BigInteger factorial = new BigInteger("1");
        while (n > 0) {
            factorial = factorial.multiply(BigInteger.valueOf(n));
            n = n - 1;
        }

        return factorial;
    }

    private static int digitCount() {
        // modulo 10 also works
        int num = 123345;
        String numStr = String.valueOf(num);
        System.out.println(numStr.length());
        return numStr.length();
    }


    //System.out.println(Long.reverseBytes(-8673877739230461952L));

    /**
     * Returns the index of the element to be searched
     */
    private static int linearSearch(int[] arr, int size, int elementToBeFound) {
        int i;
        for (i = 0; i < size; i++) {
            if (arr[i] == elementToBeFound) {
                return i;
            }
        }
        return -1;
    }

    //printSumOfFirstnNaturalNumbers(4);
    private static void printSumOfFirstnNaturalNumbers(int n) {
        int sum = 0;
        for (int index = 1; index <= n; index++) {
            sum = sum + index;
        }
        System.out.println(sum);
    }

    private static void convertYamlToObject() throws IOException {
        File file = new File(String.valueOf(Path.of("/Users/hmaryt/Documents/TYY/Simple/src/main/resources/fileOne.yaml")));
        YamlToObject yamlToObject = UtilityProvider.objectMapper.readValue(file, YamlToObject.class);
        YamlToObject yamlToObject1 = UtilityProvider.objectMapper.readValue(file, YamlToObject.class);

        System.out.println(yamlToObject.getId());
        System.out.println(yamlToObject1.getId());
    }

    private static void matrix() {

        String[][] matrix = {{"00", "01", "02"}, {"10", "11", "12"}};//2x3  2 rows 3 column ----> length=2

        System.out.println(matrix.length);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void isArmstrong() {
        int n = 407;
        int number = n;
        int sum = 0;
        int remainder;

        do {
            remainder = number % 10;
            sum = sum + (remainder * remainder * remainder);
            number = number / 10;
        } while (number > 0);
        System.out.println(sum == n);
    }

    private static void getReverseNumber() {
        int number = 12345678;
        int reverse = 0;
        do {
            reverse = reverse * 10 + (number % 10);
            number = number / 10;
        } while (number > 0);

        System.out.println("Reverse: " + reverse);
    }

    private static boolean isPalidromeNumber(int input) {
        return isPalidrome(String.valueOf(input));
    }

    private static boolean isPalidrome(String input) {
        char[] reverse = new char[input.length()];

        for (int index = (input.length() - 1); index >= 0; index--) {
            reverse[index] = input.charAt(index);
        }
        System.out.println(reverse);
        return Arrays.equals(reverse, input.toCharArray());
    }

    private static void printFibonacciTriangle(int n) {
        for (int index = 0; index < n; index++) {
            printFibonacciSeries(index);
            System.out.println();
        }
    }

    private static void printFibonacciSeries(int n) {
        int n1 = 0;
        int n2 = 1;
        int n3;

        for (int index = 0; index < n; index++) {
            if (index == 0) {
                System.out.print(n1 + "\t");
            } else if (index == 1) {
                System.out.print(n2 + "\t");
            } else {
                n3 = n1 + n2;
                System.out.print(n3 + "\t");
                n1 = n2;
                n2 = n3;
            }
        }
    }
}

/*


System.out.println(LocalDateTime.of(2021, 9, 9, 10, 15, 30).toEpochSecond(ZoneOffset.UTC));

        Long sid = 10L;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(sid);

        System.out.println(stringBuilder);
        //1631182530



public static boolean checkedObjectInstance(Object object) {
        List<?> list = (List<?>) object;
        AtomicInteger count = new AtomicInteger();
        list.forEach(element -> {
            if (element instanceof TestDataBean) {
                count.getAndIncrement();
            }
        });
        return count.get()==list.size();
    }


 */
/*

public void validateUpdateMessageResponse(@Nonnull final MessageUpdateResponse messageUpdateResponse,
                                              GatewayITConstants.TESTDATA testDataMessageBeanEnum,
                                              GatewayITConstants.TESTDATA testDataMessageMimeBeanEnum,
                                              GatewayITConstants.TESTDATA testDataUpdateMessageBeanEnum,
                                              GatewayITConstants.TESTDATA testDataListMessagesBeanEnum,
                                              Map<GatewayITConstants.TESTDATA, Object> map) {

        TestDataUpdateMessageBean testDataUpdateMessageBean = (TestDataUpdateMessageBean) testDataMap.get(testDataUpdateMessageBeanEnum);
        TestDataMessageMimeBean testDataMessageMimeBean = (TestDataMessageMimeBean) testDataMap.get(testDataMessageMimeBeanEnum);
        TestDataListMessagesBean testDataListMessagesBean = (TestDataListMessagesBean) testDataMap.get(testDataListMessagesBeanEnum);
        TestDataMessageBean testDataMessageBean = (TestDataMessageBean) testDataMap.get(testDataMessageBeanEnum);




        Assert.assertNotNull(messageUpdateResponse);
    }
    validateUpdateMessageResponse(messageUpdateResponse, testDataMessageBeanEnum, testDataMessageMimeBeanEnum,
                testDataUpdateMessageMimeBean, testDataListMessages, map);


 */