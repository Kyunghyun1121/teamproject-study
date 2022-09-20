package domain;

public class Member {
    private String name;
    private Long age;

    public Member(String name, Long age) {
        this.name = name;
        this.age = age;
    }


    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
