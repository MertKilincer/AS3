public class AddMember implements Command{

    private Member member;

    public AddMember(Library library,String type) {
        if (type.equals("A")){
            this.member=new Academic(library.getMembers().size()+1);
            library.getMembers().add(member);
        } else if (type.equals("S")) {
            this.member=new Student(library.getMembers().size()+1);
            library.getMembers().add(member);
        }
    }

    @Override
    public void execute(Library library) {
        library.updateOutput("Created new member: "+member.info());
    }
}
