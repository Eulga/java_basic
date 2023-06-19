package week5.homework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Book> bookList = Arrays.asList(
                new Book(1L, "모두의 딥러닝", "조태호", "IT", 21600),
                new Book(2L, "이득우의 게임 수학", "이득우", "IT", 40500),
                new Book(3L, "자바 웹 개발 워크북", "구멍가게 코딩단", "IT", 31500),
                new Book(4L, "실전 시계열 분석", "에일린 닐슨", "IT", 34200),
                new Book(5L, "데이터 분석가의 숫자유감", "권정민", "IT", 14400),
                new Book(6L, "스프링 부트 실전 활용 마스터", "그렉 턴키스트", "IT", 25200),
                new Book(7L, "오늘부터 IT를 시작합니다", "고코더", "IT", 16200),
                new Book(8L, "그림으로 이해하는 인지과학", "기타하라 요시노리", "IT", 16200),
                new Book(9L, "괜찮아, 그 길 끝에 행복이 기다릴 거야", "손미나", "여행", 17100),
                new Book(10L, "여행의 이유", "김영하", "여행", 12150),
                new Book(11L, "여행의 시간", "김진애", "여행", 16200),
                new Book(12L, "로봇 시대 살아남기", "염규현", "역사", 14850),
                new Book(13L, "경제 전쟁의 흑역사", "이완배", "역사", 15750),
                new Book(14L, "100가지 동물로 읽는 세계사", "사이먼 반즈", "역사", 29700),
                new Book(15L, "k 배터리 레볼루션", "박순혁", "경제", 17100),
                new Book(16L, "정하준의 경제학 레시피", "장하준", "경제", 16200),
                new Book(17L, "레버리지", "롭 무어", "경제", 16200)
        );

        // 카테고리가 여행인 책 제목 조회
        bookList.stream()
                .filter(a -> a.getCategory().equals("여행"))
                .map(Book::getBookName)
                .forEach(System.out::println);

        //가격이 16200원 이하인 책 제목 조회
        bookList.stream()
                .filter(a -> a.getPrice() <= 16200)
                .map(Book::getBookName)
                .forEach(System.out::println);

        // 책 제목에 "경제" 라는 용어가 들어간 책 제목 조회
        bookList.stream()
                .map(Book::getBookName)
                .filter(bookName -> bookName.contains("경제"))
                .forEach(System.out::println);

        // 가격이 가장 비싼 책 가격 조회
        Double maxPrice = bookList.stream()
                .map(Book::getPrice)
                .max(Comparator.comparingDouble(x -> x))
                .orElse(555D);

        Double mixPrice = bookList.stream()
                .map(Book::getPrice)
                .min(Comparator.comparingDouble(x -> x))
                .orElseGet(() -> {
                    System.out.println("elseGet실행");
                    return 555D;
                });

        Double price1 = bookList.stream()
                .map(Book::getPrice)
                .max(Comparator.comparingDouble(x -> x))
                .orElseThrow();

        Double price2 = bookList.stream()
                .map(Book::getPrice)
                .max(Comparator.comparingDouble(x -> x))
                .orElseThrow(Exception::new);


        System.out.println("책 목록 중 가장 비싼 금액: " + maxPrice);
        System.out.println();

        // 카테고리가 IT인 책들의 가격 합 조회
        double sum1 = bookList.stream()
                .filter(a -> a.getCategory().equals("IT"))
                .mapToDouble(Book::getPrice)
                .sum();

        double sum2 = bookList.stream()
                .filter(a -> a.getCategory().equals("IT"))
                .mapToDouble(Book::getPrice)
                .reduce(Double::sum)
                .orElseThrow();

        System.out.println("카테고리 IT 책들의 가격 합: " + sum1);
        System.out.println();

        // IT 책 할인 이벤트!
        List<Book> discountedBookList =
                bookList.stream()
                        .filter(a -> a.getCategory().equals("IT"))
                        .peek(book -> book.setPrice(book.getPrice() * 0.6))
                        .collect(Collectors.toList());

        for (Book book : discountedBookList) {
            System.out.println("할인된 책 제목: " + book.getBookName());
            System.out.println("할인된 책 가격: " + book.getPrice() + "\n");
        }

    }
}

class Book {
    // 분류번호
    private Long id;
    // 책 이름
    private String bookName;
    // 작가 이름
    private String author;
    // 카테고리
    private String category;
    // 가격
    private double price;

    public Book(Long id, String bookName, String author, String category, double price) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}