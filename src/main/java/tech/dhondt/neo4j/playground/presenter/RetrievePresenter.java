package tech.dhondt.neo4j.playground.presenter;

import org.springframework.stereotype.Component;
import tech.dhondt.neo4j.playground.model.entity.Location;
import tech.dhondt.neo4j.playground.model.entity.Org;
import tech.dhondt.neo4j.playground.repository.LocationRepository;
import tech.dhondt.neo4j.playground.repository.OrgRepository;
import tech.dhondt.neo4j.playground.view.RetrieveView;
import tech.dhondt.neo4j.playground.view.component.AccordionPane;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RetrievePresenter {

    @Inject
    private LocationRepository locationRepository;
    @Inject
    private OrgRepository orgRepository;

    private RetrieveView view;

    void init() {
        view = new RetrieveView(this);
    }

    AccordionPane pane() {
        return new AccordionPane(view.getPane());
    }

    public Location findAllItemsForLocation(Long locationId) {
        List<Location> locations = locationRepository.findAllLocationsAndItemsAttachedTo(locationId);
        return locations.isEmpty() ? null : locations.get(0);
    }

    public Collection<Org> findAll() {
        Collection<Org> orgs = new ArrayList<>();
        Iterable<Org> all = orgRepository.findAll(5);
        all.forEach(orgs::add);
        return orgs;
    }

    public Collection<Location> findAllLocationsForOrg(long orgId) {
        return locationRepository.findAllLocationsForOrg(orgId).stream().filter(l -> l.getOrg() != null).collect(Collectors.toList());
    }
}