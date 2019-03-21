package tech.dhondt.neo4j.playground.presenter;

import org.springframework.stereotype.Component;
import tech.dhondt.neo4j.playground.model.entity.Org;
import tech.dhondt.neo4j.playground.repository.LocationRepository;
import tech.dhondt.neo4j.playground.repository.OrgRepository;
import tech.dhondt.neo4j.playground.repository.RoleRepository;
import tech.dhondt.neo4j.playground.repository.UserRepository;
import tech.dhondt.neo4j.playground.uitls.CompilerFeedback;
import tech.dhondt.neo4j.playground.uitls.InMemoryCompiler;
import tech.dhondt.neo4j.playground.view.InsertView;
import tech.dhondt.neo4j.playground.view.component.AccordionPane;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Component
public class InsertPresenter {

    @Inject
    private OrgRepository orgRepository;
    @Inject
    private RoleRepository roleRepository;
    @Inject
    private UserRepository userRepository;
    @Inject
    private LocationRepository locationRepository;

    private InsertView view;

    void init() {
        view = new InsertView(this);
    }

    AccordionPane pane() {
        return new AccordionPane(view.getPane());
    }

    public void fillDb(String input) {
        CompilerFeedback compilerFeedback = null;
        try {
            InMemoryCompiler.IMCSourceCode source;
            StringBuilder sb = new StringBuilder();
            sb.append("package tech.dhondt.neo4j.playground.presenter;\n");
            sb.append("import tech.dhondt.neo4j.playground.model.entity.*;\n");
            sb.append("import java.util.*;\n");
            sb.append("public class DynamicClass {\n");
            sb.append("\tpublic static List<Org> getOrgs() {\n");
            sb.append("\t\t").append(input).append("\n");
            sb.append("\t}\n");
            sb.append("}\n");
            source = new InMemoryCompiler.IMCSourceCode("tech.dhondt.neo4j.playground.presenter.DynamicClass", sb.toString());

            List<InMemoryCompiler.IMCSourceCode> classSources = new ArrayList<>();
            classSources.add(source);
            InMemoryCompiler uCompiler = new InMemoryCompiler(classSources);
            compilerFeedback = uCompiler.compile();
            if (compilerFeedback != null && compilerFeedback.success) {
                List<Org> orgs = (List<Org>) uCompiler.run(source.fullClassName, "getOrgs");
                orgRepository.saveAll(orgs);
            }
        } catch (Exception e) {
            System.out.println("\n\n\t****** EXECUTION FAILED ******\n" + compilerFeedback != null ? compilerFeedback.toString() : "" + "\n\t******************************\n\n");
        }
    }

    public void deleteAll() {
        orgRepository.deleteAll();
        roleRepository.deleteAll();
        userRepository.deleteAll();
        locationRepository.deleteAll();
    }
}