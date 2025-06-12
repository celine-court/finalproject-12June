package com.ironhack.lastProject2025.demo;

import com.ironhack.lastProject2025.model.*;
import com.ironhack.lastProject2025.model.enums.Status;
import com.ironhack.lastProject2025.service.MembershipService;
import com.ironhack.lastProject2025.service.SportClubService;
import com.ironhack.lastProject2025.service.RoleService;
import com.ironhack.lastProject2025.service.UserService;
import com.ironhack.lastProject2025.repository.MembershipRepository;
import com.ironhack.lastProject2025.repository.MemberRepository;
import com.ironhack.lastProject2025.repository.SportClubRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.ironhack.lastProject2025.model.enums.SportType.CLUB_NAUTICO;
import static com.ironhack.lastProject2025.model.enums.SportType.MARTIAL_ARTS;
import static com.ironhack.lastProject2025.model.enums.SportType.DANCE;
import static com.ironhack.lastProject2025.model.enums.SportType.PADEL;
import static com.ironhack.lastProject2025.model.enums.SportType.TENNIS;


@Component
public class DataLoader implements CommandLineRunner {

    private final SportClubRepository sportClubRepository;
    private final MembershipRepository membershipRepository;
    private final MemberRepository memberRepository;
    private final UserService userService;
    private final RoleService roleService;

    public DataLoader(SportClubRepository sportClubRepository, MembershipRepository membershipRepository, MemberRepository memberRepository, UserService userService, RoleService roleService) {
        this.sportClubRepository = sportClubRepository;
        this.membershipRepository = membershipRepository;
        this.memberRepository = memberRepository;
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {


        roleService.save(new Role("ROLE_USER"));
        roleService.save(new Role("ROLE_ADMIN"));

        userService.saveUser(new User("John Doe", "john", "1234"));
        userService.saveUser(new User("James Smith", "james", "1234"));
        userService.saveUser(new User("Jane Carry", "jane", "1234"));
        userService.saveUser(new User("Chris Anderson", "chris", "1234"));

        roleService.addRoleToUser("john", "ROLE_USER");
        roleService.addRoleToUser("james", "ROLE_ADMIN");
        roleService.addRoleToUser("jane", "ROLE_USER");
        roleService.addRoleToUser("chris", "ROLE_ADMIN");
        roleService.addRoleToUser("chris", "ROLE_USER");


        // Create SportClub
        SportClub clubA = new SportClub("Real Club Náutico de Palma Sport", "Eliane Ramirez", "Muelle de Sant Pere, 1, 07012 Palma, Illes Balears",8,"contact@realclub.com", CLUB_NAUTICO,Collections.emptySet());
        SportClub clubB = new SportClub("Club Náutico Portixol Sport", "Jane Dosy", "Muelle de Sant Pere, 1, 07012 Palma, Illes Balears", 6,"contact@realclub.com", CLUB_NAUTICO,Collections.emptySet());
        SportClub clubC = new SportClub("Club élite taekwondo Ramos & Brigitte club", "Pedro Sanchez", "Carrer de la Sínia d'en Gil, 4, Ponent, 07011 Palma, Illes Balears",8, "contact@eliteclub.com", MARTIAL_ARTS,Collections.emptySet());
        SportClub clubD = new SportClub("Dojo Zen Palma", "Juan Alvarez", "Carrer del Rei Sanç, 19, Nord, 07004 Palma, Illes Balears", 5,"contact@eliteclub.com", MARTIAL_ARTS,Collections.emptySet());

        sportClubRepository.saveAll(List.of(clubA,clubB,clubC, clubD));


        // Create Members with statuses and associate with SportClub
        Member member1 = new Member("John", "Doe", "john.smith@example.com", Status.USERMEMBER, new HashSet<>(),new HashSet<>());
        Member member2 = new Member("Jane", "Carry", "jane.carry@example.com", Status.USERMEMBER, new HashSet<>(),new HashSet<>());

        memberRepository.saveAll(List.of(member1,member2));


        // Create Memberships with ratings
        Membership membership1 = new Membership(member1, clubA, 4.5);
        Membership membership2 = new Membership(member2, clubA, 5.0);

        membershipRepository.saveAll(List.of(membership1,membership2));



        //printing club and member info
        System.out.println(membership1);
        System.out.println(membership2);

    }




}
