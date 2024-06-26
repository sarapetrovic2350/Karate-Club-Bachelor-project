package KarateClub.config;

import KarateClub.model.RestAuthenticationEntryPoint;
import KarateClub.model.TokenAuthenticationFilter;
import KarateClub.model.TokenUtils;
import KarateClub.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Servis koji se koristi za citanje podataka o korisnicima aplikacije
    @Autowired
    private CustomUserDetailsService jwtUserDetailsService;

    // Handler za vracanje 401 kada klijent sa neodogovarajucim korisnickim imenom i lozinkom pokusa da pristupi resursu
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    // Injektujemo implementaciju iz TokenUtils klase kako bismo mogli da koristimo njene metode za rad sa JWT u TokenAuthenticationFilteru
    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

    // Registrujemo authentication manager koji ce da uradi autentifikaciju korisnika za nas
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // Definisemo prava pristupa za zahteve ka odredjenim URL-ovima/rutama
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // komunikacija izmedju klijenta i servera je stateless posto je u pitanju REST aplikacija
                // ovo znaci da server ne pamti nikakvo stanje, tokeni se ne cuvaju na serveru
                // ovo nije slucaj kao sa sesijama koje se cuvaju na serverskoj strani - STATEFULL aplikacija
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                // sve neautentifikovane zahteve obradi uniformno i posalji 401 gresku
                .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()

                // svim korisnicima dopusti da pristupe sledecim putanjama:
                .authorizeRequests()
                .antMatchers("/auth/*").permitAll()
                .antMatchers("/user/*").permitAll()
                .antMatchers("/group/*").permitAll()
                .antMatchers( "/competition/checkIfClubIsRegistered","/competition/registerStudentToDisciplineForCompetition",
                        "/competition/getDisciplinesForCompetition/{competitionId}", "/competition/getCompetitionsDisciplinesWithRegisteredStudents/{clubId}",
                        "/competition/registerClubToCompetition", "/competition/findAll", "/competition/getCompetitionMedalsForKarateClub/{clubId}",
                        "/competition/getDisciplinesOfCompetitionForStudent/{userId}","/competition/getDisciplineByCompetitionDisciplineId/{competitionId}/{disciplineId}",
                        "/competition/getCompetitionsClubIsRegisteredTo/{clubId}","/competition/getCompetitionById/{competitionId}","/competition/getAll").permitAll()
                .antMatchers("/discipline/*").permitAll()
                .antMatchers("/medal/*").permitAll()
                .antMatchers("/membershipFee/*").permitAll()
                // za svaki drugi zahtev korisnik mora biti autentifikovan
                .anyRequest().authenticated().and().httpBasic().and().cors().and()

                // umetni custom filter TokenAuthenticationFilter kako bi se vrsila provera JWT tokena
                // umesto cistih korisnickog imena i lozinke (koje radi BasicAuthenticationFilter)
                .addFilterBefore(new TokenAuthenticationFilter(tokenUtils, jwtUserDetailsService),
                        BasicAuthenticationFilter.class);
                http.cors();
                http.csrf().disable();
    }

    // Definisanje konfiguracije koja utice na generalnu bezbednost aplikacije
    @Override
    public void configure(WebSecurity web) throws Exception {
        // Autentifikacija ce biti ignorisana ispod navedenih putanja (kako bismo ubrzali pristup resursima)
        // Zahtevi koji se mecuju za web.ignoring().antMatchers() nemaju pristup SecurityContext-u
        // Dozvoljena POST metoda na ruti /auth/login, za svaki drugi tip HTTP metode greska je 401 Unauthorized

        web.ignoring().antMatchers(HttpMethod.POST, "/auth/login");
        web.ignoring().antMatchers(HttpMethod.PUT, "/auth/activate-account/*");
        web.ignoring().antMatchers(HttpMethod.GET,
                "/webjars/**", "/*.html", "/favicon.ico",
                "/**/*.html", "/**/*.css", "/**/*.js");

    }
}
